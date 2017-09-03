package com.ank.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ank.shoppingbackend.dao.ProductDAO;
import com.ank.shoppingbackend.dto.Product;
@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
    @Autowired 
	private SessionFactory sessionFactory;
	
    
    @Override
	public Product get(int productId) {
	 try {
		 return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(productId));
	 }catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
    	
    	return null;
	}

	@Override
	public List<Product> list() {
		// TODO Auto-generated method stub
		try {
				return sessionFactory.getCurrentSession()
						.createQuery("FROM PRODUCT",Product.class)
						.getResultList();
		}catch (Exception e) {
		e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean add(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public List<Product> listActiveProduct() {
		// TODO Auto-generated method stub
		try {
			 String getActiveProduct="FROM Product WHERE active =:active";
			 return sessionFactory.getCurrentSession()
			.createQuery(getActiveProduct,Product.class)
			.setParameter("active", true)
			.getResultList();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> listActiveProductByCategory(int categoryId) {
		// TODO Auto-generated method stub
		try {
			String activeProductByCategory="FROM Product WHERE active= :active AND category_id= :categoryId";
			return sessionFactory.getCurrentSession()
					.createQuery(activeProductByCategory,Product.class)
					.setParameter("active", true)
					.setParameter("categoryId", categoryId)
					.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		// TODO Auto-generated method stub
		try {
			String activeProductByCategory="From Product Where active= :active ORDER BY id";
			return sessionFactory.getCurrentSession()
					.createQuery(activeProductByCategory,Product.class)
					.setParameter("active", true)
					.setFirstResult(0)
					.setMaxResults(count)
					.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
