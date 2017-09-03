package com.ank.shoppingbackend.dao;

import java.util.List;

import com.ank.shoppingbackend.dto.Product;

public interface ProductDAO {
  
   Product get(int productId);
   List<Product> list();
   boolean add(Product product);
   boolean update(Product product);
   boolean delete(Product product);
  
   List<Product> listActiveProduct();
   List<Product> listActiveProductByCategory(int categoryId);
   List<Product> getLatestActiveProducts(int count);

}
