package com.chris.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chris.pojo.ProductCategory;
import com.chris.repository.ProductCategoryRepository;
import com.chris.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private ProductCategoryRepository respository;

	@Override
	public List<ProductCategory> findAll() {
		
		return respository.findAll();
	}

	@Override
	public ProductCategory findOne(Integer categoryId) {
		
		return respository.findById(categoryId).get();
	}

	@Override
	public List<ProductCategory> findByCategoryTypeIn(List<Integer> categorys) {
		
		return respository.findByCategoryTypeIn(categorys);
	}

	@Override
	public ProductCategory save(ProductCategory category) {
		
		return respository.save(category);
	}

}
