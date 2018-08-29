package com.springboot.sell.repository;

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


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        Optional<ProductCategory> productCategory = repository.findById(1);
        System.out.println(productCategory);
    }

    @Test
    public void findSaveTest() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryId(4);
        productCategory.setCategoryName("天下4");
        productCategory.setCategoryType(1004);
        repository.save(productCategory);
    }

    @Test
    public void findSaveTest0() {
        ProductCategory productCategory = new ProductCategory("风云", 1004);
        repository.save(productCategory);
    }

    @Test
    public void findSaveTest1() {
        ProductCategory productCategory = repository.findById(1).get();
        productCategory.setCategoryName("雄霸天下4");
        repository.save(productCategory);
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list = Arrays.asList(2, 3, 1004);
        List<ProductCategory> productCategories = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, productCategories.size());
    }

}