package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dataobject.ProductInfo;
import com.springboot.sell.enums.ProductStatus;
import com.springboot.sell.enums.ResultEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImpTest {

    @Autowired
    private ProductInfoServiceImp productInfoServiceImp;


    @Test
    public void saveProductInfo() {
        ProductInfo info = new ProductInfo();
        info.setProductId("1234567");
        info.setProductName("油条");
        info.setProductPrice(new BigDecimal(1.2));
        info.setProductDescription("好有好油");
        info.setProductIcon("http:baodu.com");
        info.setProductStock(1);
        info.setProductStatus(0);
        info.setCategoryType(1);
        ProductInfo productInfo = productInfoServiceImp.saveProductInfo(info);
        Assert.assertNotNull(productInfo);
    }

    @Test
    public void findOne() {
        Optional<ProductInfo> productInfo = productInfoServiceImp.findOne("123456");
        Assert.assertNotNull(productInfo.get());
    }

    @Test
    public void findALL() {
        //new PageRequest(0, 2)废弃 替换 静态of
        PageRequest page = new PageRequest(0, 2);
//        Page pageObj = productInfoServiceImp.findALL(page);
        Page pageObj = productInfoServiceImp.findALL(PageRequest.of(0,2));
        System.out.println(pageObj.getTotalElements());
        Assert.assertNotEquals(0, pageObj.getTotalPages());
    }

    @Test
    public void findUPALL() {
        List<ProductInfo> list = productInfoServiceImp.findUPALL();
        Assert.assertNotEquals(0, list.size());
    }
    @Test
    public void onSale(){
      ProductInfo productInfo =   productInfoServiceImp.onSale("123456");
      Assert.assertEquals(ProductStatus.UP,productInfo.getProductStatusEnum());
    }
    @Test
    public void offSle(){
        ProductInfo productInfo  =  productInfoServiceImp.offSale("123456");
        Assert.assertEquals(ProductStatus.DOWN,productInfo.getProductStatusEnum());
    }

}