package com.spring_mvc.admin.dao;

import java.util.List;

import com.spring_mvc.admin.entities.Category;
import com.spring_mvc.admin.entities.Product;

public interface CategoryDAO {

	List<Category> getAll();
	Boolean create(Category cate);
	Category find(Integer categoryID);
	Boolean update(Category cate);
	Boolean delete(Integer categoryID);
	public List<Category> pagination(int pageno , int pagesize);
	int count ();
	
	public List<Category> findName(String keyword,int pageno,int pagesize);
	int countPage (String name);
}
