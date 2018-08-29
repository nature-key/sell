package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dataobject.ProductCategory;
import com.springboot.sell.repository.ProductCategoryRepository;
import com.springboot.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImp implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public Optional<ProductCategory> findOne(Integer Id) {
        return productCategoryRepository.findById(Id);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> productCategoryList) {
        return productCategoryRepository.findByCategoryTypeIn(productCategoryList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
