package com.ank.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ank.shoppingbackend.dao.ProductDAO;
import com.ank.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/api")
public class JsonDataController {

@Autowired
private ProductDAO productDAO;

@RequestMapping("/all/products")
@ResponseBody
public List<Product> getAllProducts(){
 return productDAO.listActiveProduct();	

}

@RequestMapping("/category/{id}/products")
@ResponseBody
public List<Product> getProductByCategory(@PathVariable int id)
{
	return productDAO.listActiveProductByCategory(id);
	}	
}
