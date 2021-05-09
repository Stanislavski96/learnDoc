package com.chris.test;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.chris.pojo.ProductCategory;
import com.chris.repository.ProductCategoryRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
	@Autowired
	private ProductCategoryRepository repository;
	
	@Test
	public void test() {
		ProductCategory category=new ProductCategory();
		category.setCategoryId(1);
		Example<ProductCategory> example=Example.of(category);
		Optional<ProductCategory> res= repository.findOne(example);
		ProductCategory one =res.get();
		System.out.println(one.toString());
	}
	
	@Test
	@Transactional
	public void  testS() {
		List<Integer> categorys =Arrays.asList(2,3,4,5);
		List<ProductCategory> res= repository.findByCategoryTypeIn(categorys);
		for(ProductCategory item:res) {
			System.out.println(item.getCategoryName());
		}
	}
}
