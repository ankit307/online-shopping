package com.ank.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ank.shoppingbackend.dao.CategoryDAO;
import com.ank.shoppingbackend.dto.Category;
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	private static List<Category> categories=new ArrayList<>();
	static {
		Category c1=new Category();
		c1.setId(1);
		c1.setName("Television");
		c1.setDescription("this is a test");
		c1.setActive(true);
		c1.setImageURL("asd");
		categories.add(c1);
		c1=new Category();
		c1.setId(2);
		c1.setName("Phone");
		c1.setDescription("this is a test");
		c1.setActive(true);
		c1.setImageURL("asd");
		categories.add(c1);
		c1=new Category();
		c1.setId(3);
		c1.setName("Computers");
		c1.setDescription("this is a test");
		c1.setActive(true);
		c1.setImageURL("asd");
		categories.add(c1);
		
	}
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		for(Category category:categories)
			if(category.getId()==id) return category;
		// TODO Auto-generated method stub
		return null;
	}

}
