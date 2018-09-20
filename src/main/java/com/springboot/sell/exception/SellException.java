package com.springboot.sell.exception;

import com.springboot.sell.enums.ResultEnum;
import lombok.Getter;

@Getter
public class SellException extends RuntimeException{
    private Integer code;
    public SellException(ResultEnum resultEnum){
      super(resultEnum.getMessage());
    }

    public SellException(Integer code,String message) {
        super(message);
        this.code = code;
    }
}
