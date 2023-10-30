package com.spring_mvc.admin.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_mvc.admin.dao.UserDAO;
import com.spring_mvc.admin.entities.User;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			User user = (User) session.createQuery("from User where userName = :userName")
			.setParameter("userName", username)
			.uniqueResult();
			System.out.println(user);
			return user;
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

}
