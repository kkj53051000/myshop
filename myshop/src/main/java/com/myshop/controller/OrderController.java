package com.myshop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.myshop.domain.Order;
import com.myshop.domain.Orderinfo;
import com.myshop.domain.Productinfo;
import com.myshop.domain.User;
import com.myshop.dto.UserSession;
import com.myshop.service.OrderService;
import com.myshop.service.OrderinfoService;
import com.myshop.service.ProductService;
import com.myshop.service.ProductinfoService;
import com.myshop.service.UserService;
import com.myshop.vo.OrderForm;
import com.myshop.vo.ProductinfoOrderForm;

import lombok.Getter;
import lombok.Setter;

@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	@Autowired
	OrderinfoService orderinfoService;
	@Autowired
	ProductinfoService productinfoService;
	@Autowired
	ProductService productService;
	@Autowired
	UserService userService;
	
	
	@PostMapping("/order")
	public String order(@RequestBody List<OrderRequest> orderRequest, OrderForm orderForm, HttpServletRequest request) {
		
		/*
		for(int i = 0; i < orderRequest.size(); i++) {
			System.out.println(i + "번째 상품번호" + orderRequest.get(i).getProductId());
			System.out.println(i + "번째 수량" + orderRequest.get(i).getAmount());
		}
		*/
		
		// order 주문 시 필요한것 (수량, 유저, 상품)
		// 세션 가져와서 유저 가져오기, 상품정보 가져와서 상품가져오기
		
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession)session.getAttribute("user");
		
		User user = userService.findUser(userSession.getId());
		
		List<Productinfo> productinfos = new ArrayList<Productinfo>();
		
		for(int i = 0; i < orderRequest.size(); i++) {
			Productinfo productinfo = productinfoService.getInfo(orderRequest.get(i).getProductId());
			productinfos.add(productinfo);
		}
		
		// 주문 처리
		Order order = new Order(user);
		
		orderService.saveOrder(order);
		
		order = orderService.getOrder(order.getId());
		
		
		for(int i = 0; i < orderRequest.size(); i++) {
			Orderinfo orderinfo = new Orderinfo(orderRequest.get(i).getAmount(), order, productinfos.get(i));
			orderinfoService.saveorderinfo(orderinfo);
		}
		
		// 상품 수량 수정
		for(int i = 0; i < orderRequest.size(); i++) {
			ProductinfoOrderForm productinfoOrderForm = new ProductinfoOrderForm(productinfos.get(i), orderRequest.get(i).getAmount());
			productinfoService.orderInfo(productinfoOrderForm);
		}

		return "redirect:/";
	}
	@Getter
	@Setter
	public static class OrderRequest{
		
		OrderRequest() {}
		
		public long productId;
		public int amount;
	}
	
	/*
	@Getter
	@Setter
	static class OrderRequest {
		
		List<OrderInfo> orders;
		
		@Getter
		@Setter
		public static class OrderInfo{
			public long productId;
			public int amount;
		}
	}
	*/
	
	
	
	@PostMapping("/order/cancel")
	public String orderCancel(HttpServletRequest request) {
		long productinfo_id = Long.parseLong(request.getParameter("productinfo_id"));
		Productinfo productinfo = productinfoService.getInfo(productinfo_id);
		
		long order_id = Integer.parseInt(request.getParameter("order_id"));
		Order order = orderService.getOrder(order_id);
		
		
		//productinfoService.cancelInfo(productinfo, order.getOrderAmount());
		orderService.cancelOrder(order);
		
		return "redirect:/order/list";
		
	}
	
	@GetMapping("/order/list")
	public String orderDetails(HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		UserSession userSession = (UserSession)session.getAttribute("user");
		
		List<Order> orders = orderService.getOrders(userSession.getId());
		
		model.addAttribute("orders", orders);
		
		return "order-details";
	}
	
	
	
	
	
	@PostMapping("/test")
	public String test(@RequestBody MyRequest myRequest) {
		// myRequest.getOrders().get(0).productId;
		return "";
	}
	
	
	/*
	 * {
	 * 	name: "DFD",
	 *  age : 3,
	 *  orders: [
	 *  	{ productId: 3 },
	 *      { productId: 3 }
	 *  ]
	 * }
	 * 
	 * 
	 * */
	
	
	
	@Getter
	@Setter
	static class MyRequest {
		public String name;
		public int age;
		
		public List<Orders> orders;
		
		@Getter
		@Setter
		public static class Orders {
			public int productId;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
