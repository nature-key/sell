package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dataobject.ProductCategory;
import com.springboot.sell.dataobject.ProductInfo;
import com.springboot.sell.enums.ProductStatus;
import com.springboot.sell.repository.ProductInfoRepository;
import com.springboot.sell.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductInfoServiceImp implements ProductInfoService{


    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo saveProductInfo(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    public Optional<ProductInfo> findOne(String Id) {
        return productInfoRepository.findById(Id);
    }

    @Override
    public Page<ProductInfo> findALL(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public List<ProductInfo> findUPALL() {
        return productInfoRepository.findByProductStatus(ProductStatus.UP.getCode());
    }
}
