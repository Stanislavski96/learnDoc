package com.chris.service;

import com.chris.dto.OrderDTO;


public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
