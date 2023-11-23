package com.spring_mvc.admin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring_mvc.admin.security.entities.CustomUserDetails;

@Controller
public class HomeController {
	@RequestMapping(value = {"/login" })
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("mess", "Login failed!");
		}
		return "admin/login";
	}

	@RequestMapping("/logout")
	public String logout(Model model) {
		model.addAttribute("mess", "Has Logged out!!!");
		return "admin/login";
	}
	
	
	@RequestMapping(value = "/checkrole")

	public String checkRole() {

	//lấy thông tin tài khoản

	CustomUserDetails account = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	//duyệt role để kiểm tra và điều hướng

	for(var g: account.getAuthorities()) {

	if(g.getAuthority().equals("ROLE_ADMIN")) {

	return "redirect:/admin";

	}

	if(g.getAuthority().equals("ROLE_USER")) {

	return "redirect:/home";

	}

	}

	return "admin/403";

	}
	
	@RequestMapping("/403")

	public String accessDenied(Model model) {

	model.addAttribute("msg", "BẠN KHÔNG CÓ QUYỀN TRUY CẬP VÀO TRANG NÀY");

	return "admin/403";

	}
	
	
}
