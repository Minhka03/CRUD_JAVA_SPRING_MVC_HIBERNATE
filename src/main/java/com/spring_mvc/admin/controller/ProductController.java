package com.spring_mvc.admin.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.spring_mvc.admin.dao.CategoryDAO;
import com.spring_mvc.admin.dao.ProductDAO;
import com.spring_mvc.admin.dto.ProductDTO;
import com.spring_mvc.admin.entities.Category;
import com.spring_mvc.admin.entities.Product;
@RequestMapping(value = "/admin")
@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ModelMapper modelMapper;
	@RequestMapping(value="/product")
	public String index(Model model, @RequestParam(name="pageno", required = false)String pageno , @RequestParam(name="keyword", required = false)String keyword) {
		int pageNo = 1;
		int pagesize = 5;
		var totalPage = 1;
		pageNo = pageno!= null ? Integer.parseInt(pageno) : 1;
		var count = productDAO.count();
		var listPage = productDAO.pagination(pageNo, pagesize);
		totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
		if (keyword != null) {
			listPage = productDAO.findName(keyword, pageNo, pagesize);
			count = productDAO.countPage(keyword);
			totalPage = count % pagesize == 0 ? count / pagesize : (count / pagesize) + 1;
			model.addAttribute("listPage", listPage);
			model.addAttribute("totalPage", totalPage);
			return "admin/product/index";
		} else {
			model.addAttribute("listPage", listPage);
			model.addAttribute("totalPage", totalPage);
			return "admin/product/index";
		}
	}
	@GetMapping(value = "/product/add")
	public String add(Model model) {
		Product product = new Product();
		List<Category> listCategory = categoryDAO.getAll();
		model.addAttribute("product", product);
		model.addAttribute("listCategory", listCategory);
		return "admin/product/add";
	}
	
	@PostMapping(value = "/product/add")
	public String save(@Valid @ModelAttribute("product")ProductDTO product , BindingResult result , @RequestParam("image")MultipartFile fileImage, HttpServletRequest request , Model model) {
		if(result.hasErrors()) {
			List<Category> listCategory = categoryDAO.getAll();
			model.addAttribute("product", product);
			model.addAttribute("listCategory",listCategory);
			return "admin/product/add";
		}else {
			// xu ly upload file 
			String path = request.getServletContext().getRealPath("resources/uploads/images");
			File f = new File(path);
			String fileName = fileImage.getOriginalFilename();
			File distination = new File(f.getAbsolutePath()+"/"+fileName);
			if(!distination.exists()) {
				try {
					Files.write(distination.toPath(), fileImage.getBytes(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			Product productDTO = modelMapper.map(product, Product.class);
			productDTO.setImage(fileName);
			if(productDAO.create(productDTO)) {
				return "redirect:/admin/product";
			}else {
				return "admin/product/add";
			}
			
		}
		
	}
	@GetMapping(value = "/product/editProduct/{id}")
	public String edit(Model model,@PathVariable Integer id) {
		Product product = productDAO.find(id);
		List<Category> listCategory = categoryDAO.getAll();
		model.addAttribute("product", product);
		model.addAttribute("listCategory",listCategory);
		return "admin/product/edit";
	}
	
	@PostMapping(value = "/product/editProduct/{id}")
	public String update(@ModelAttribute("product")Product product , BindingResult result , @RequestParam("image")MultipartFile fileImage, HttpServletRequest request) {
		// xu ly upload file 
		String fileName = fileImage.getOriginalFilename();
		boolean isEmpty = fileName == null || fileName.trim().length() == 0;
		
		if(!isEmpty) {
			String path = request.getServletContext().getRealPath("resources/uploads/images");
			File f = new File(path);
			File distination = new File(f.getAbsolutePath()+"/"+fileName);
			if(!distination.exists()) {
				try {
					Files.write(distination.toPath(), fileImage.getBytes(), StandardOpenOption.CREATE);
					product.setImage(fileName);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}else {
			Product currentProduct = productDAO.find(product.getProductId());
			product.setImage(currentProduct.getImage());
		}
		if(productDAO.update(product)) {
			return "redirect:/admin/product";
		} else {
			return "admin/product/edit";
		}
	}
	@GetMapping("/product/deleteProduct/{id}")
	public String delete(@PathVariable  String id,RedirectAttributes redirectAttrs) {
		
		if(productDAO.delete(Integer.parseInt(id))) {
			redirectAttrs.addFlashAttribute("success", "Xóa thành công");
			return "redirect:/admin/product";
		}
		return "redirect:/";
		
	}
}
