package com.spring_mvc.admin.dao;

import com.spring_mvc.admin.entities.User;


public interface UserDAO {
	 User findByUserName(String username);
}
