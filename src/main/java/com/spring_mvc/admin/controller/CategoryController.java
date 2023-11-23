package com.spring_mvc.admin.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_mvc.admin.dao.CategoryDAO;
import com.spring_mvc.admin.entities.Category;
@RequestMapping(value = "/admin")
@Controller
public class CategoryController {
	
	
	@Autowired
	private CategoryDAO categoryDao;
	
	@RequestMapping(value="/category")
	public String index(Model model, @RequestParam(name="pageno", required = false)String pageno , @RequestParam(name="keyword" , required = false)String keyword)  {
		int pageNo = 1;
		int pagesize = 5;
		var totalPage = 1;
		pageNo = pageno!= null ? Integer.parseInt(pageno) : 1;
		var count = categoryDao.count();
		var listPage = categoryDao.pagination(pageNo, pagesize);
		totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		if (keyword != null) {
			listPage = categoryDao.findName(keyword, pageNo, pagesize);
			count = categoryDao.countPage(keyword);
			totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
			model.addAttribute("listPage", listPage);
			model.addAttribute("totalPage", totalPage);
			return "admin/category/index";
		} else {
			model.addAttribute("listPage", listPage);
			model.addAttribute("totalPage", totalPage);
			return "admin/category/index";
			
		}
	}
	
	
	@GetMapping (value="/category/add")
	public String add(Model model) {
		Category cate = new Category();
		model.addAttribute("category", cate);
		return "admin/category/add";
	}
	
	
	@PostMapping(value="/category/add")
	public String save (@Valid @ModelAttribute("category")Category category, BindingResult result,  HttpServletRequest request, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("category", category);
			return "admin/category/add";
		}else {
			
			if(categoryDao.create(category)) {	
				List<Category> list = categoryDao.getAll();
				model.addAttribute("list", list);
				return "redirect:/admin/category";
			} 
			return "admin/category/add";
		}
	}
	
	@GetMapping(value = "/category/editCategory/{id}")
	public String edit(@PathVariable Integer id , Model model) {
		Category category = categoryDao.find(id);
		model.addAttribute("category", category);
		return "admin/category/edit";
	}
	
	
	@PostMapping(value = "/category/editCategory/{id}")
	public String update(@Valid @ModelAttribute("category")Category category , BindingResult result , Model model) {
		if(result.hasErrors()) {
			return "admin/category/edit";
			
		}else {
			if(categoryDao.update(category)) {
				List<Category> list = categoryDao.getAll();
				model.addAttribute("list", list);
				return "redirect:/admin/category";
			} 
			return "admin/category/edit";
			
		}
	}
	
	@GetMapping(value = "/category/deleteCategory/{id}")
	public String delete(@PathVariable Integer id, Model model) {
		categoryDao.delete(id);
		return "redirect:/admin/category";
	}
	
}
