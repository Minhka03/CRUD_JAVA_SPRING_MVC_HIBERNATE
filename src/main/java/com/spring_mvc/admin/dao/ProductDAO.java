package com.spring_mvc.admin.dao;

import java.util.List;

import com.spring_mvc.admin.entities.Product;

public interface ProductDAO {

	public List<Product> getAll();
	public Boolean create(Product product);
	public Product find(Integer productID);
	public Boolean update(Product product);
	public Boolean delete(Integer productID);
	public List<Product> pagination(int pageno , int pagesize);
	int count ();
	
	public List<Product> findName(String keyword,int pageno,int pagesize);
	int countPage (String name);
	
}
