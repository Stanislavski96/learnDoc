package com.chris.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chris.dto.OrderDTO;
import com.chris.service.impl.OrderServiceImpl;


import com.chris.pojo.OrderDetail;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderServiceTest {
	@Autowired
	private OrderServiceImpl service;
	
	@Test
	public void testCreate() {
		OrderDTO dto=new OrderDTO();
		dto.setOrderId("00001");
		dto.setBuyerName("chris");
		dto.setBuyerAddress("WuHan University of since and terchonology");
		dto.setBuyerPhone("12345678987");
		dto.setOrderStatus(2);
		dto.setPayStatus(1);
		dto.setOrderAmount(new BigDecimal(19.5));
		dto.setBuyerOpenid("wsxedcrfvthn");
		List<OrderDetail> detaillist=new ArrayList<>();
		for(int i=1;i<10;i++){
			OrderDetail one=new OrderDetail();
			one.setDetailId(String.valueOf(i));
			one.setOrderId(String.valueOf(i*2));
			StringBuilder pic=new StringBuilder("http:/localhost/project/prcture");
			pic.append(i*2);
			one.setProductIcon(pic.toString());
			one.setProductId(String.valueOf(i*3));
			one.setProductName("prodict"+String.valueOf(i));
			one.setProductQuantity(i*36);
			one.setProductPrice(new BigDecimal(i*5.6));
			detaillist.add(one);
		}
		dto.setOrderDetailList(detaillist);
		service.create(dto);
	}
}
