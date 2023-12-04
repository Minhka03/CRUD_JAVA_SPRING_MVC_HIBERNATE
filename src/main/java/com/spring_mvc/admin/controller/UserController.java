package com.spring_mvc.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.admin.dao.CartDAO;
import com.spring_mvc.admin.dao.CategoryDAO;
import com.spring_mvc.admin.dao.ProductDAO;
import com.spring_mvc.admin.dao.UserDAO;
import com.spring_mvc.admin.entities.Cart;
import com.spring_mvc.admin.entities.Product;
import com.spring_mvc.admin.entities.User;
import com.spring_mvc.admin.security.entities.CustomUserDetails;

@RequestMapping(value = "/")
@Controller
public class UserController {

	
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private UserDAO userDAO;
	@RequestMapping("/")
	
	public String userPage(Model model,@ModelAttribute("product") Product product) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof CustomUserDetails) { 
		    CustomUserDetails account = (CustomUserDetails) principal;
		    // Kiểm tra nếu tên người dùng không phải là null, thêm thông tin người dùng vào model
		    if (account.getUsername() != null) {
		        model.addAttribute("user", account);
		    }
		}
		
		model.addAttribute("listProduct", productDAO.getAll());
		return "homeCus";
	}
	
	@RequestMapping("/product/{id}")
	public String product(Model model, @PathVariable Integer id) {
		Product product = productDAO.find(id);
		model.addAttribute("product", product);
		return "product";
	}
	@RequestMapping("/shop")
	public String shop(Model model) {
		model.addAttribute("mess", "Welcome user page");
		return "shop";
	}
	@GetMapping("/cart")
	public String cart(Model model) {
		model.addAttribute("listCart", cartDAO.getAll());
		return "Cart";
	}
	
	
	
	
}
