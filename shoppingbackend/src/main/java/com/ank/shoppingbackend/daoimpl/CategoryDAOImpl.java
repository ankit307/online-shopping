package com.ank.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.ank.shoppingbackend.dao.CategoryDAO;
import com.ank.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories = new ArrayList<>();
	@Autowired
	private SessionFactory sessionFactory;
		
	@Override
	public List<Category> list() {
		 String selectActivCategory="From Category Where active= :active";
		 Query query=sessionFactory.getCurrentSession().createQuery(selectActivCategory);
		 query.setParameter("active", true);
		return query.getResultList();
	}
	/**
	 * Getting single Category Base on id
	 */
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	@Override
	public boolean add(Category category) {
		try {
		sessionFactory.getCurrentSession().persist(category);
			 return true;
		} catch (Exception e) {
			e.printStackTrace();
			 return false;
		}
	}

	@Override
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
				 return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		return false;
	}

}
