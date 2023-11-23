package com.spring_mvc.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_mvc.admin.dao.CategoryDAO;
import com.spring_mvc.admin.dao.ProductDAO;
import com.spring_mvc.admin.entities.Product;

@RequestMapping(value = "/")
@Controller
public class UserController {

	
	@Autowired
	private CategoryDAO categoryDao;
	@Autowired
	private ProductDAO productDAO;
	@RequestMapping("/")
	public String userPage(Model model,@ModelAttribute("product") Product product) {
		
		model.addAttribute("listProduct", productDAO.getAll());
		return "homeCus";
	}
	
	@RequestMapping("/product")
	public String product(Model model) {
		model.addAttribute("mess", "Welcome user page");
		return "product";
	}
	@RequestMapping("/cart")
	public String cart(Model model) {
		model.addAttribute("mess", "Welcome user page");
		return "Cart";
	}
	
	
}
