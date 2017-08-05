package com.ank.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.ank.shoppingbackend.dao.CategoryDAO;
import com.ank.shoppingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.ank.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}
	
	/*@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("TVscad");
		category.setDescription("this is test");
		category.setImageurl("as.jpeg");
		category.setActive(true);
		System.out.println("Trying to add" + category);
		categoryDAO.add(category);
	//	assertEquals("Successfull Added to table", true, categoryDAO.add(category));
	}*/
	/*@Test
	public void testGetCategory() {
		category=categoryDAO.get(1);
		assertEquals("Successfull get category from table", "TV", category.getName());
	}*/
/*	@Test
	public void testUpdateCategory() {
		category=categoryDAO.get(1);
		category.setName("Television");
		assertEquals("Successfull Updated category from table", true, categoryDAO.update(category));
	}*/
	/*@Test
	public void testDeleteCategory() {
		category=categoryDAO.get(1);
		assertEquals("Successfull Delete category from table", true, categoryDAO.delete(category));
	}*/
	@Test
	public void testListCategory() {
		assertEquals("Successfull Fetched the list category from table", 3, categoryDAO.list().size());
	}
}
