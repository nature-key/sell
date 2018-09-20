package com.springboot.sell.service;

import com.springboot.sell.dto.OrderDTO;

public interface PushMessage {

    void orderStatus(OrderDTO orderDTO);
}
