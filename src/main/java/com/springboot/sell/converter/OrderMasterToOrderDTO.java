package com.springboot.sell.converter;

import com.springboot.sell.dataobject.OrderMaster;
import com.springboot.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMasterToOrderDTO {
    public static OrderDTO converter(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> converterList(List<OrderMaster> orderMasterList) {
      return   orderMasterList.stream().map(e ->
                converter(e)
        ).collect(Collectors.toList());
    }
}
