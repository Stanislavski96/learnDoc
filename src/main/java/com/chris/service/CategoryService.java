package com.chris.service;

import java.util.List;


import com.chris.pojo.ProductCategory;


public interface CategoryService {
	List<ProductCategory> findAll();
	
	ProductCategory findOne(Integer categoryId);
	
	List<ProductCategory> findByCategoryTypeIn(List<Integer> categorys);
	
	ProductCategory save(ProductCategory category);
	
}
