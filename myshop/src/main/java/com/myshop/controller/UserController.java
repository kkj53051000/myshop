package com.myshop.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myshop.domain.User;
import com.myshop.dto.UserSession;
import com.myshop.service.UserService;
import com.myshop.vo.UserForm;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String MainPage() {
		return "main";
	}
	
	@GetMapping("/join")
	public String JoinPage() {
		return "join";
	}
	
	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}
	
	@PostMapping("/user/join")
	public String Join(UserForm userForm) {
		User user = new User(userForm.getUserid(), userForm.getUserpw(), userForm.getNickname(), userForm.getEmail());
		
		userService.joinUser(user);
		
		return "redirect:/";
	}
	
	@PostMapping("/user/login")
	public String Login(UserForm userForm, HttpServletRequest request) {
		
		User user = userService.loginUser(userForm);
		
		if(user == null) {
			return "redirect:/";
		}else {
			HttpSession session = request.getSession();
			UserSession userSession = new UserSession(user.getId(), user.getUserid(), user.getNickname(), user.getEmail(), user.getRole());
			session.setAttribute("user", userSession);
			
			return "redirect:/";
		}
		
	}
	
	@GetMapping(value = "/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
