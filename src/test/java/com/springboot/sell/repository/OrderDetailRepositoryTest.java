package com.springboot.sell.repository;

import com.springboot.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void Save(){

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("123456");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http:xx.jpa");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("视频");
        orderDetail.setProductPrice(new BigDecimal(12.3));
        orderDetail.setProductQuantity(12);
        OrderDetail result =  repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
      List<OrderDetail> orderDetailList= repository.findByOrderId("123456");
      Assert.assertNotEquals(0,orderDetailList.size());
    }
}