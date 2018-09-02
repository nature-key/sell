package com.springboot.sell.exception;

import com.springboot.sell.enums.ResultEnum;

public class SellException extends RuntimeException{
    private Integer code;
    public SellException(ResultEnum resultEnum){
      super(resultEnum.getMessage());
    }
}