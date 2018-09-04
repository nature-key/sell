package com.springboot.sell.viewobject;

import lombok.Data;

import java.util.List;


@Data
public class ResponseVO<T> {

    private Integer code;
    private String msg;
    private T data;

}
