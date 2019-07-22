package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnotherController {

	
	@RequestMapping("/")
	public String greet()
	{
		return "login";
	}
	
	@RequestMapping("/verify")
	public String verifyMethod(HttpServletRequest request)
	{
		String name=request.getParameter("user");
		System.out.println("welcome "+ name);
		HttpSession session=request.getSession();
		session.setAttribute("name", name);
		return "welcome";
		
	}
}
