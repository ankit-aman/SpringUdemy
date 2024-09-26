package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processPage() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		String name=request.getParameter("studentName");
		 name= name.toUpperCase();
		
		 String message= "Yo!"+name;
		 model.addAttribute("message",message);
		
		return "helloworld";
		
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
		
		//String name=request.getParameter("studentName");
		 name= name.toUpperCase();
		
		 String message= "Yo! mahn"+name;
		 model.addAttribute("message",message);
		
		return "helloworld";
		
	}
	
	
	
	
}
