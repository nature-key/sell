package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dataobject.SellerInfo;
import com.springboot.sell.repository.SellerInfoRepository;
import com.springboot.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImp implements SellerService{
    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerByOpenid(String openid) {
        return sellerInfoRepository.findByAndOpenid(openid);
    }
}
