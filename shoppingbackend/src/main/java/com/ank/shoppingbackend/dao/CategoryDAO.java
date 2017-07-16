package com.ank.shoppingbackend.dao;

import java.util.List;

import com.ank.shoppingbackend.dto.Category;

public interface CategoryDAO {
List<Category> list();
Category get(int id);	
}
