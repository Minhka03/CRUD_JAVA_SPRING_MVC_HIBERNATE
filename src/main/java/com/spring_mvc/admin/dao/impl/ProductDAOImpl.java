package com.spring_mvc.admin.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_mvc.admin.dao.ProductDAO;
import com.spring_mvc.admin.entities.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Product").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean create(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.save(product);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Product find(Integer productID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Product product = session.get(Product.class, productID);
			return product;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public Boolean update(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(product);
			session.getTransaction().commit();
			System.out.println("dung");
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
	public Boolean delete(Integer productID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(productID));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Product> pagination(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List<Product> listPage = session.createQuery("from Product p ORDER BY p.productId DESC", Product.class)
					.setFirstResult((pageno - 1 ) * pagesize ).setMaxResults(pagesize).getResultList();
			return listPage; 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	@Override
	public int count() {
		int total = 0; 
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Product", Product.class).list().size();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return total;
	}

	@Override
	public List<Product> findName(String keyword, int pageno, int pagesize) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		try {
			List<Product> listsearch = session.createQuery("from Product where lower(productName) like lower(:keyword)", Product.class).setParameter("keyword", "%" + keyword + "%")
			.setFirstResult((pageno - 1 ) * pagesize ).setMaxResults(pagesize).getResultList();
			return listsearch;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int countPage(String name) {
		// TODO Auto-generated method stub
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Product where lower(productName) like lower(:name)", Product.class).setParameter("name", "%" + name+ "%").list().size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}

}
