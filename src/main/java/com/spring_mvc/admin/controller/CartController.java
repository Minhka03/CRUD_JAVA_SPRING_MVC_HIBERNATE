package com.spring_mvc.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.spring_mvc.admin.dao.CartDAO;
import com.spring_mvc.admin.dao.ProductDAO;
import com.spring_mvc.admin.dao.UserDAO;
import com.spring_mvc.admin.entities.Cart;
import com.spring_mvc.admin.entities.Product;
import com.spring_mvc.admin.entities.User;
import com.spring_mvc.admin.security.entities.CustomUserDetails;

@Controller
public class CartController {
	@Autowired
	private CartDAO cartDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private ProductDAO productDAO;
	@PostMapping(value = "/cart")
	public String add(Model model, @RequestParam(name = "productId", required = false) Integer productId) {
		CustomUserDetails user = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal(); 
		Product product = productDAO.find(productId);
		User u = userDAO.findByUserName(user.getUsername());

		if (product != null && u != null) {
			List<Cart> Cart = cartDAO.getAll();
			Cart cartExisting = null;
			for (Cart cartItem : Cart) {
				if (cartItem.getProduct().getProductId().equals(product.getProductId()))
					cartExisting = cartItem;
				break;
			}
			if (cartExisting != null) {
				cartExisting.setQuantity(cartExisting.getQuantity() + 1);
				cartExisting.setTotalPrice(
						cartExisting.getQuantity() * (product.getPrice() * (100 - (product.getSale_price())) / 100));
				cartDAO.update(cartExisting);
			} else {
				Cart cartNew = new Cart();
				cartNew.setProduct(product);
				cartNew.setQuantity(1);
				cartNew.setTotalPrice((product.getPrice() * (100 - (product.getSale_price())) / 100));
				cartNew.setUser(u);
				cartDAO.create(cartNew);
			}
		}

		return "redirect:/cart";
	}
	
	
	@PostMapping(value = "/update_quantity")
	public String updateCartItem(@RequestParam("productId") int productId, @RequestParam("quantity") int quantity) {  
		System.out.println("vao chua lk=kkkkkk");
		Product product = productDAO.find(productId);
		List<Cart> listCart = cartDAO.getAll(); 
		Cart cartExisting = null;
		for (Cart cartItem : listCart) {
				cartExisting = cartItem;
			break;
		}
		if(cartExisting!=null) {
			cartExisting.setQuantity(quantity);
			cartExisting.setTotalPrice(cartExisting.getQuantity() * (product.getPrice() * (100 - (product.getSale_price())) / 100));
			cartDAO.update(cartExisting);
			return "redirect:/cart";
		}
		
		return null; 
		
    }

}
