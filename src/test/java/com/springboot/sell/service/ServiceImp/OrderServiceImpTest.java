package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dataobject.OrderDetail;
import com.springboot.sell.dto.OrderDTO;
import com.springboot.sell.enums.OrderStatus;
import com.springboot.sell.enums.PayStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImpTest {
    @Autowired
    private OrderServiceImp orderServiceImp;

    private final String BUYER_OPENID = "1101110";
    private final String ORDER_ID = "1535979559245309857";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("悟空八戒");
        orderDTO.setBuyerAddress("北京西安");
        orderDTO.setBuyerPhone("119");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123456");
        orderDetail.setProductQuantity(50);
        orderDetailList.add(orderDetail);

        orderDTO.setOrderDetailList(orderDetailList);
        OrderDTO result = orderServiceImp.create(orderDTO);

        log.info("常见订单" + result);


    }

    @Test
    public void findOne() {
        OrderDTO orderDTO = orderServiceImp.findOne(ORDER_ID);
        Assert.assertNotNull(orderDTO);
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0,2);
       Page<OrderDTO> orderDTOPage= orderServiceImp.findList(BUYER_OPENID,request);
       Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderServiceImp.findOne(ORDER_ID);
        OrderDTO orderDTOresult =  orderServiceImp.cancel(orderDTO);
        Assert.assertEquals(OrderStatus.CANCEL.getCode(),orderDTOresult.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderServiceImp.findOne(ORDER_ID);
        OrderDTO orderDTOresult =  orderServiceImp.finish(orderDTO);
        Assert.assertEquals(OrderStatus.FINISHED.getCode(),orderDTOresult.getOrderStatus());

    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderServiceImp.findOne(ORDER_ID);
        OrderDTO orderDTOresult =  orderServiceImp.paid(orderDTO);
        Assert.assertEquals(PayStatus.SUCCESS.getCode(),orderDTOresult.getPayStatus());

    }
}