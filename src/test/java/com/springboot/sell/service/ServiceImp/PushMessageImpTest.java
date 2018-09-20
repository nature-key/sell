package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dto.OrderDTO;
import com.springboot.sell.service.OrderService;
import com.springboot.sell.service.PushMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest

public class PushMessageImpTest {

    @Autowired
    private PushMessage pushMessage;
    @Autowired
    private OrderService orderService;

    @Test
    public void orderStatus() {

        OrderDTO orderDTO = orderService.findOne("1536849082622793153");

        pushMessage.orderStatus(orderDTO);
    }
}