package com.chris.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chris.pojo.ProductCategory;
import com.chris.service.CategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {
	
	@Autowired
	private CategoryService service;
	
	@Test
	public void testAll() {
		service.findAll();
	}
	
	
	@Test
	public void testSave() {
		ProductCategory category=new ProductCategory();
		category.setCategoryName("快餐");
		category.setCategoryType(6);
		service.save(category);
	}
}
