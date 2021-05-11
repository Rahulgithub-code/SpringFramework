package com.spring.mvc.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RedirectControllerDemo {

	@RequestMapping("one")
	public RedirectView one() {
		System.out.println("This is one handler");

		// method 1 : Redirect prefix
		// return "redirect:/enjoy";

		// method 2 : redirect View
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("enjoy");
		return redirectView;
	}

	@RequestMapping("/enjoy")
	public String two() {
		System.out.println("this is second handler.");
		return "contact";
	}

	@RequestMapping("three")
	public RedirectView three() {
		System.out.println("This is one handler");

		// method 1
		// return "redirect:/enjoy";

		// method 2
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("http://www.google.com");
		return redirectView;
	}

	// method 3 : Using HttpServletResponse (Traditional not recommended)

//	@RequestMapping("/forth")
//	public String forth(HttpServletResponse res) {
//		try {
//			res.sendRedirect("enjoy");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return "";
//	}

}
