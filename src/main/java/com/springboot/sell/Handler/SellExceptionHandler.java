package com.springboot.sell.Handler;

import com.springboot.sell.config.ProjectUrlConfig;
import com.springboot.sell.exception.SellAuthorizeException;
import com.springboot.sell.exception.SellException;
import com.springboot.sell.utils.ResponseUtils;
import com.springboot.sell.viewobject.ResponseVO;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SellExceptionHandler {

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @ExceptionHandler(value = SellAuthorizeException.class)
    public ModelAndView handlerAuthorizeException(){
       return  new ModelAndView("redirect:"
//       .concat(projectUrlConfig.wechatMpAuthorize)
       .concat(projectUrlConfig.getSell())
       .concat("/sell/wechst/qrAuthorize")
       .concat("?returnUrl=")
       .concat(projectUrlConfig.getSell())
       .concat("/sell/seller/login"));
    }


    @ExceptionHandler(value = SellException.class)
    @ResponseBody
    public ResponseVO handlerSellerException(SellException e){
            return ResponseUtils.error(e.getCode(),e.getMessage());
    }
}
