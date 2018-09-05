package com.springboot.sell.service;

import com.springboot.sell.dto.OrderDTO;

public interface BuyerService {

    OrderDTO findOrderOne(String openid,String orderId);
    OrderDTO cancelOrder(String openid,String orderId);
}
