package com.chris.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.chris.pojo.OrderDetail;
import com.chris.dto.OrderDTO;
import com.chris.enums.ResultEnum;
import com.chris.exception.SellException;
import com.chris.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 廖师兄
 * 2017-06-18 23:41
 */
@Slf4j
public class OrderForm2OrderDTOConverter {
	
	private static Logger log=LoggerFactory.getLogger(OrderForm2OrderDTOConverter.class);

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误, string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
