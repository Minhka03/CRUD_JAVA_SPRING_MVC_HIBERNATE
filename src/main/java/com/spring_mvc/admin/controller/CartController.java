package com.spring_mvc.admin.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.spring_mvc.admin.dao.CartDAO;
import com.spring_mvc.admin.dao.UserDAO;
import com.spring_mvc.admin.security.entities.CustomUserDetails;
@Controller
public class CartController {

	@Autowired 
	private CartDAO cartDAO;
	@Autowired 
	private UserDAO userDAO;
	@RequestMapping(value = "/addCart")
	public String add(Model model) {
//		CustomUserDetails user =  (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		model.addAttribute("user", user);
//		System.out.println(user.getUsername());
		
		return "Cart";
	}
	
}
