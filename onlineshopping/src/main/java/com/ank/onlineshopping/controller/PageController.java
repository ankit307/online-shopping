package com.ank.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ank.shoppingbackend.dao.CategoryDAO;
import com.ank.shoppingbackend.dto.Category;

@Controller
public class PageController {
    @Autowired
    private CategoryDAO categoryDAO;
	@RequestMapping(value= {"/","/index","/home"})
	public ModelAndView index() {
		ModelAndView model= new ModelAndView("page");
		model.addObject("userClickHome",true);
		model.addObject("categories", categoryDAO.list());
		model.addObject("title", "Home");
		return model;
	}
	@RequestMapping(value= "/about")
	public ModelAndView aboutus() {
		ModelAndView model= new ModelAndView("page");
		model.addObject("userClickAbout",true);
		model.addObject("title", "About Us");
		return model;
	}
	@RequestMapping(value= "/contact")
	public ModelAndView contactus() {
		ModelAndView model= new ModelAndView("page");
		model.addObject("userClickContact",true);
		model.addObject("title", "Contact Us");
		return model;
	}

	@RequestMapping(value= "/show/all/products")
	public ModelAndView showaAllProducts() {
		ModelAndView model= new ModelAndView("page");
		model.addObject("userClickAllProducts",true);
		model.addObject("categories", categoryDAO.list());
		
		model.addObject("title", "All Products");
		//model.addObjects("products",productDAO.list());
		return model;
	}
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView showaCategoryProducts(@PathVariable("id") int id) {
		//geting single Category
		Category category=null;
		category=categoryDAO.get(id);
		ModelAndView model= new ModelAndView("page");
		model.addObject("userClickCategoryProducts",true);
		model.addObject("title", category.getName());
		model.addObject("category",category);
		model.addObject("categories", categoryDAO.list());
		
		//model.addObjects("products",productDAO.list());
		return model;
	}
}
