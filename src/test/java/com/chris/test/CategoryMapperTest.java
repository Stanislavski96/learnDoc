package com.chris.test;

import java.util.HashMap;
import java.util.Map;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chris.pojo.ProductCategory;
import com.chris.pojo.mapper.ProductCategoryMapper;

import junit.framework.TestCase;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryMapperTest {
	
	@Autowired
	private ProductCategoryMapper mapper;
	
	@Test
	public void testInsert() {
		Map<String, Object> source=new HashMap<>();
		source.put("category_name","piza");
		source.put("category_type",17);
		int res=mapper.insertByMap(source);
		TestCase.assertEquals(1, res);
	}
	
	@Test
	public void testSelect() {
		ProductCategory category= mapper.findByCategoryType(13);
		TestCase.assertEquals("coco", category.getCategoryName());
	}
	
}
