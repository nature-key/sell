package com.springboot.sell.enums;

import lombok.Generated;
import lombok.Getter;

@Getter
public enum ProductStatus {
    UP(0, "上架"),
    DOWN(1, "下架");

    private Integer code;
    private String messsage;

    ProductStatus(Integer code, String messsage) {
        this.code = code;
        this.messsage = messsage;
    }
}
