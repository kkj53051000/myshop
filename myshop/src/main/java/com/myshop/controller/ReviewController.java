package com.myshop.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.myshop.domain.Productinfo;
import com.myshop.domain.Review;
import com.myshop.domain.Reviewimg;
import com.myshop.domain.User;
import com.myshop.dto.UserSession;
import com.myshop.service.ProductinfoService;
import com.myshop.service.ReviewService;
import com.myshop.service.ReviewimgService;
import com.myshop.service.UserService;


@Controller
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductinfoService productinfoService;
	
	private ReviewimgService reviewimgService;
	
	@GetMapping("/review-upload")
	public String reviewUploadPage(){
		return "review-upload";
	}
	
	@PostMapping("/review/uplaod")
	public String ReviewUpload(MultipartHttpServletRequest mtfRequest, HttpServletRequest request, HttpSession session) {
		UserSession userSession = (UserSession)session.getAttribute("user");
		User user = userService.findUser(userSession.getId());
		
		List<MultipartFile> fileList = mtfRequest.getFiles("img");
		String content = request.getParameter("content");
		
		long productId = Long.parseLong(request.getParameter("productid"));
		Productinfo productinfo = productinfoService.getInfo(productId);
		 
		String realPath = request.getServletContext().getRealPath("/upload");
			
		String temp = "";
		
		for(int i=0; i < realPath.indexOf("webapp"); i++) {
			temp += realPath.charAt(i);
	    }
		
		String publicRealPath = temp + "resources" +  File.separator + "public" + File.separator + "upload" + File.separator;
		
		Review review = new Review(content, user, productinfo);
		
		reviewService.saveReview(review);
		
		 for (MultipartFile mf : fileList) {
            String originFileName = mf.getOriginalFilename(); // 원본 파일 명
            long fileSize = mf.getSize(); // 파일 사이즈
            
            String filePath = publicRealPath + originFileName;
			
			String clientPath = "/public/upload/" + originFileName;

            System.out.println("originFileName : " + originFileName);
            System.out.println("fileSize : " + fileSize);
            
            Reviewimg reviewimg = new Reviewimg(clientPath, review);
            reviewimgService.saveReviewimg(reviewimg);

            try {
                mf.transferTo(new File(filePath));
            } catch (IllegalStateException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
	
		return "/";
	}
}
