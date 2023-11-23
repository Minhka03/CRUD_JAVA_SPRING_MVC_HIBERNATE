package com.spring_mvc.admin.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring_mvc.admin.dao.CategoryDAO;
import com.spring_mvc.admin.entities.Category;
import com.spring_mvc.admin.entities.Product;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Category p order by p.categoryId desc").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean create(Category cate) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(cate);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	
	}
	@Override
	public Category find(Integer categoryID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Category category = session.get(Category.class, categoryID);
			return category;
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public Boolean update(Category cate) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(cate);
			session.getTransaction().commit();
			System.out.println(cate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public Boolean delete(Integer categoryID) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.delete(find(categoryID));
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			session.close();
		}
		return false;
	}

	@Override
	public List<Category> pagination(int pageno, int pagesize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List<Category> listPage = session.createQuery("from Category c ORDER BY c.categoryId DESC", Category.class)
					.setFirstResult((pageno - 1 ) * pagesize ).setMaxResults(pagesize).getResultList();
			return listPage;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		int total = 0;
		Session session = sessionFactory.openSession();
		try {
			total = session.createQuery("from Category", Category.class).list().size();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			session.close();
		}
		return total;
	}

	@Override
	public List<Category> findName(String keyword, int pageno, int pagesize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			List<Category> listsearch = session.createQuery("from Category where lower(categoryName) like lower(:keyword)", Category.class).setParameter("keyword", "%" + keyword + "%")
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
			total = session.createQuery("from Category where lower(categoryname) like lower(:name)", Category.class).setParameter("name", "%" + name+ "%").list().size();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}

}
