package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyAppController {
	
	
	public MyAppController()
	{
		System.out.println("MyAppController crwetaed..");
		
	}
	
	@RequestMapping("/abc")
	//@ResponseBody
	public String someMethod() {
		System.out.println("You have accesses /abc url path...");
		//return "demo.html";
		//return "<h1>This is the content as response to client</h1>";
		return "view/demo.jsp";
	}
	
	@RequestMapping("/xyz")
	public String anotherMthod()
	{
		return "demo";
	}


	@RequestMapping("/verify2")
	public String verifyMethod2(@RequestParam("user") String name,@RequestParam("pwd") String pwd,HttpSession session)
	{

		System.out.println("welcome "+ name);
		session.setAttribute("name", name);
		return "welcome";
		
	}
	
	@RequestMapping("/verify3")
	public String verifyMethod3( String user,String pwd,HttpSession session)
	{

		System.out.println("welcome "+ user);
		session.setAttribute("name", user);
		session.setAttribute("pwd", pwd);
		return "welcome";
		
	}
	
	@RequestMapping("/verify4")
	public ModelAndView verifyMethod4( Person p)
	{

		ModelAndView mv=new ModelAndView();
		mv.addObject("person", p);
		mv.setViewName("loggedIn");
		return mv;
		
	}
}
