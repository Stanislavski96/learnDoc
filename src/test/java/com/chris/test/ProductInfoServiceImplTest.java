package com.chris.test;

import java.math.BigDecimal;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chris.pojo.ProductInfo;
import com.chris.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductInfoServiceImplTest {
	@Autowired
	private ProductServiceImpl service;
	
	@Test
	public void test() {
		for(int i=1;i<10;i++) {
			ProductInfo productInfo=new ProductInfo();
			productInfo.setProductId(Integer.toString(i*3));
			productInfo.setProductName("奶茶"+i);
			productInfo.setCategoryType(2);
			productInfo.setProductIcon("http://pricture/12");
			productInfo.setProductPrice(new BigDecimal(15));
			productInfo.setProductStatus(0);
			productInfo.setProductStock(11256);
			productInfo.setProductDescription("奶茶"+i*6);
			
			ProductInfo res=service.save(productInfo);
			if(null==res) {
				System.out.println("fetal error");
			}
		}		
		
	}
	
	@Test
	public void testFindOne() {
		String productId="2";
		ProductInfo info=service.findOne(productId);
		System.out.print(info.getProductDescription());;
	}
}
