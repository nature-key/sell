package com.springboot.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.springboot.sell.dataobject.OrderDetail;
import com.springboot.sell.dto.OrderDTO;
import com.springboot.sell.enums.ResultEnum;
import com.springboot.sell.exception.SellException;
import com.springboot.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderFormToOrderDTO {

    public  static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems().toString(), new TypeToken<List<OrderDetail>>() {
            }.getType());


        } catch (Exception error) {
            log.error("【对象转换错误】string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
       return orderDTO ;
    }
}
