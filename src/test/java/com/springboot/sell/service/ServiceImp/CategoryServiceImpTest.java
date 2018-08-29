package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImpTest {

    @Autowired
    private CategoryServiceImp categoryServiceImp;

    @Test
    public void findOne() {
        Optional<ProductCategory> productCategory = categoryServiceImp.findOne(1);

        Assert.assertNotNull(productCategory.get());
    }

    @Test
    public void findAll() {
        List<ProductCategory> list = categoryServiceImp.findAll();
        Assert.assertNotEquals(0, list.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List category = Arrays.asList(1004, 1001);
        List<ProductCategory> list = categoryServiceImp.findByCategoryTypeIn(category);
        Assert.assertNotEquals(0, list.size());

    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory("延禧攻略", 1005);

        ProductCategory productCategory1 = categoryServiceImp.save(productCategory);
        Assert.assertNotNull(productCategory1);
    }
}