package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dto.OrderDTO;
import com.springboot.sell.enums.ResultEnum;
import com.springboot.sell.exception.SellException;
import com.springboot.sell.service.BuyerService;
import com.springboot.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImp implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIT);
        }
        return orderService.cancel(orderDTO);
    }

    public OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO != null) {
            return null;
        }
        if (orderDTO.getBuyerOpenid().equals(openid)) {
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
