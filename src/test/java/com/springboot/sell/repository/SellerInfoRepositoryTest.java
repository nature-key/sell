package com.springboot.sell.repository;

import com.springboot.sell.dataobject.SellerInfo;
import com.springboot.sell.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoRepositoryTest {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;


    @Test
    public void save(){
        SellerInfo sellerInfo = new SellerInfo();
        sellerInfo.setOpenid("abc");
        sellerInfo.setPassword("admin");
        sellerInfo.setUsername("admin");
        sellerInfo.setSellerId(KeyUtil.getUniqueKey());
        SellerInfo info =  sellerInfoRepository.save(sellerInfo);
        Assert.assertNotNull(info);
    }



    @Test
    public void findByOAndOpenid() {
        SellerInfo sellerInfo =   sellerInfoRepository.findByAndOpenid("abc");
        Assert.assertEquals("abc",sellerInfo.getOpenid());

    }
}