package com.springboot.sell.controller;


import com.mysql.jdbc.util.ResultSetUtil;
import com.springboot.sell.converter.OrderFormToOrderDTO;
import com.springboot.sell.dto.OrderDTO;
import com.springboot.sell.enums.ResultEnum;
import com.springboot.sell.exception.SellException;
import com.springboot.sell.form.OrderForm;
import com.springboot.sell.service.OrderService;
import com.springboot.sell.utils.ResponseUtils;
import com.springboot.sell.viewobject.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/create")
    public ResponseVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderFormToOrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】 购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO orderDTOResult = orderService.create(orderDTO);
        Map<String, String> map = new HashMap<>();
        map.put("orderId", orderDTOResult.getOrderId());
        return ResponseUtils.success(map);
    }

}
