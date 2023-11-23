package com.spring_mvc.admin.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_mvc.admin.dao.CartDAO;
import com.spring_mvc.admin.entities.Cart;
@Repository
public class CartDAOImpl implements CartDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<Cart> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Cart c ORDER BY c.id DESC").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean create(Cart cart) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.save(cart);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Cart find(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
		Cart cart = session.get(Cart.class, id);
			return cart;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean update(Cart cart) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(cart);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer id) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(id));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
		return false;
	}

	

}
