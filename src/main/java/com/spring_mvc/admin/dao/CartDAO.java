package com.spring_mvc.admin.dao;

import java.util.List;
import com.spring_mvc.admin.entities.Cart;
public interface CartDAO {

	public List<Cart> getAll();
	public Boolean create(Cart cart);
	public Cart find(Integer id);
	public Boolean update(Cart cart);
	public Boolean delete(Integer id);
	

}
