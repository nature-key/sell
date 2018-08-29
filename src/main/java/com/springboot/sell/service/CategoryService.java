package com.springboot.sell.service;

import com.springboot.sell.dataobject.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Optional<ProductCategory> findOne(Integer Id);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategoryList);
    ProductCategory save(ProductCategory productCategory);
}
