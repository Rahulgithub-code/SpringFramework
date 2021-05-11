package com.spring.mvc.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.model.User;
import com.spring.mvc.service.UserService;

@Controller
public class ContactController {
	
	@Autowired
	private UserService userService;
	
	//comman data for each page 
	@ModelAttribute
	public void commonData(Model m) {
		m.addAttribute("headr", "this is header.");
		m.addAttribute("desc","This is description.");
		System.out.println("comman method is loaded.");
	}

	@RequestMapping("/contact")
	public String showForm() {
		System.out.println("contact page loaded");
		return "contact";
	}

	// using httpServletRequest
//	@RequestMapping(path = "/processForm", method = RequestMethod.POST)
//	public String handleForm(HttpServletRequest request) {
//		String name= request.getParameter("name");
//		String email= request.getParameter("email");
//		String pass= request.getParameter("pwd");
//		System.out.println(name+" "+email+" " +pass);
//		return "";
//	}

	// Using @RequestParam
//	@RequestMapping(path = "/processForm", method = RequestMethod.POST)
//	public String handleForm(@RequestParam("name") String name, @RequestParam("email") String email,
//			@RequestParam("pwd") String pass , Model model) {
//		System.out.println(name + " " + email + " " + pass);
//		model.addAttribute("name",name);
//		model.addAttribute("email",email);
//		model.addAttribute("pass",pass);
//		return "success";
//	}
	
	 //Using @ModelAttribute
	@RequestMapping(path = "/processForm", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		this.userService.createUser(user);
		System.out.println("handler page is loaded");
	return "success";
	}

}
