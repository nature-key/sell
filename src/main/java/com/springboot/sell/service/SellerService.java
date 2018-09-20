package com.springboot.sell.service;

import com.springboot.sell.dataobject.SellerInfo;

public interface SellerService {

    SellerInfo findSellerByOpenid(String openid);
}
