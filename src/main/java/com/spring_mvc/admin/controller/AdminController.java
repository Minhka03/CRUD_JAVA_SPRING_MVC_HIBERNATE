package com.spring_mvc.admin.controller;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.admin.security.entities.CustomUserDetails;


@Controller

public class AdminController {

	@RequestMapping("/admin")
	public String adminPage(Model model) {
		model.addAttribute("mess", "Welcome to admin page");

		CustomUserDetails user =  (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("user", user);
		System.out.println(user);
		
		return "admin/index";
	}
}
