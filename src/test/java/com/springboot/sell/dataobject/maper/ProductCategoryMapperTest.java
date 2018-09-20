package com.springboot.sell.dataobject.maper;

import com.springboot.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryMapperTest {

    @Autowired
    private ProductCategoryMapper productCategoryMapper;

    @Test
    public void insertByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("category_name", "你好");
        map.put("category_type", 1022);
        int a = productCategoryMapper.insertByMap(map);
        System.out.println(1);
        Assert.assertNotNull(a);

    }

    @Test
    public void insertByObjet() {
//        Map<String, Object> map = new HashMap<>();
//        map.put("category_name", "你好");
//        map.put("category_type", 1022);
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("dddd");
        productCategory.setCategoryType(100);
        int a = productCategoryMapper.insertByObject(productCategory);
        System.out.println(1);
        Assert.assertNotNull(a);

    }


    @Test
    public void findByObjet() {

        ProductCategory productCategory = productCategoryMapper.findByCategoryType(100);
        Assert.assertNotNull(productCategory);

    }

    @Test
    public void findByName() {

        List<ProductCategory> productCategory = productCategoryMapper.findByCategoryName("dddd");
        Assert.assertNotNull(productCategory);
    }

    @Test
    public void update() {
        int a = productCategoryMapper.updateByCategory("wangxuan", 100);
        Assert.assertEquals(1, a);
    }

    @Test
    public void updateByObject() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("ddddwwww");
        productCategory.setCategoryType(100);
        int a = productCategoryMapper.updateByObject(productCategory);
        Assert.assertEquals(1, a);
    }

    @Test
    public void delete(){
     int b=    productCategoryMapper.deleteByObject("100");
     Assert.assertEquals(1,b);
    }

}