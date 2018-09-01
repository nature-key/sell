package com.springboot.sell.service;

import com.springboot.sell.dataobject.ProductCategory;
import com.springboot.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductInfoService {

    Optional<ProductInfo> findOne(String productId);
    Page<ProductInfo> findALL(Pageable pageable);
    List<ProductInfo> findUPALL();
    ProductInfo saveProductInfo(ProductInfo productInfo);
}
