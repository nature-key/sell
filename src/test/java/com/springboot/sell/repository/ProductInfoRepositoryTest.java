package com.springboot.sell.repository;

import com.springboot.sell.dataobject.ProductInfo;
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
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
        Assert.assertNotEquals(0, list.size());


    }

    @Test
    public void SaveTest() {
        ProductInfo info = new ProductInfo();
        info.setProductId("123456");
        info.setProductName("鸡蛋");
        info.setProductPrice(new BigDecimal(1.2));
        info.setProductDescription("好吃好吃");
        info.setProductIcon("http:baodu.com");
        info.setProductStock(1);
        info.setProductStatus(0);
        info.setCategoryType(1);
        ProductInfo productInfo = productInfoRepository.save(info);
        Assert.assertNotNull(productInfo);


    }
}