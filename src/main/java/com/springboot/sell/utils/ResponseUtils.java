package com.springboot.sell.utils;

import com.springboot.sell.dataobject.ProductInfo;
import com.springboot.sell.viewobject.ProductInfoVO;
import com.springboot.sell.viewobject.ProductVO;
import com.springboot.sell.viewobject.ResponseVO;

import java.util.List;


public class ResponseUtils {

    public static ResponseVO success(Object object) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(0);
        responseVO.setMsg("成功");
        responseVO.setData(object);
        return responseVO;
    }

    public static ResponseVO success() {

        return success(null);
    }


    public static ResponseVO error(Integer code, String errorMsg) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(code);
        responseVO.setMsg(errorMsg);
        return responseVO;
    }

}
