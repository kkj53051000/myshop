package com.myshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myshop.interceptor.AuthInterceptor;

@Configuration
public class InterceptorConfog implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor())
			.addPathPatterns("");
	}
	
	public AuthInterceptor authInterceptor() {
		return new AuthInterceptor();
	}
}
