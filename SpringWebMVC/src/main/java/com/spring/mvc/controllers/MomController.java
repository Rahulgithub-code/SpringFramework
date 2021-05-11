package com.spring.mvc.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MomController {

	// server to view data sung Model
	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("home url method is invoked");
		model.addAttribute("name", "Vipul kumar prajapati");
		model.addAttribute("id", 101);
		List<String> friends = this.getFriends();
		model.addAttribute("friends",friends);
		return "index";
	}
	
	
	@RequestMapping("/about")
	public String about() {
		System.out.println(" About url method is invoked");
		return "about";
	}
	
	// server to view data sung ModelAndView
	@RequestMapping("/help")
	public ModelAndView help() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("name","Rahul");
		modelAndView.addObject("id", 102);
		LocalDateTime time = LocalDateTime.now();
		modelAndView.addObject("time",time);
		return modelAndView;
	}
	
	public List<String> getFriends(){
		List<String> friends = new ArrayList();
		friends.add("Rahul");
		friends.add("Vipul");
		friends.add("Aadarsh");
		friends.add("Gaggu");
		
		return friends;
	}
}
