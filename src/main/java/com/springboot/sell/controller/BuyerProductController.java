package com.springboot.sell.controller;

import com.springboot.sell.dataobject.ProductCategory;
import com.springboot.sell.dataobject.ProductInfo;
import com.springboot.sell.service.CategoryService;
import com.springboot.sell.service.ProductInfoService;
import com.springboot.sell.utils.ResponseUtils;
import com.springboot.sell.viewobject.ProductInfoVO;
import com.springboot.sell.viewobject.ProductVO;
import com.springboot.sell.viewobject.ResponseVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    private ProductInfoService productInfoService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResponseVO list() {

        List<ProductInfo> productInfoList = productInfoService.findUPALL();

        List<Integer> categoryList = productInfoList.stream().map(item -> item.getCategoryType()).collect(Collectors.toList());

        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryList);

        List<ProductVO> productVOList = new ArrayList<>();

        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCatogoryName(productCategory.getCategoryName());


            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())) {
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfo(productInfoVOList);
            productVOList.add(productVO);

        }

//        ResponseVO response = new ResponseVO();
//        response.setCode("0");
//        response.setMsg("火热");
//
//        response.setDate(productVOList);
        return ResponseUtils.success(productVOList);
    }
}
