package com.springboot.sell.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数不正确"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"库存不足"),
    ORDER_NOT_EXIT(12,"订单不存在"),
    ORDERDETAIL_NOT_EXIT(13,"订单详情不存在"),
    ORDER_STATUS_ERROR(14,"订单状态不正确"),
    ORDER_UPDATE_FAIL(15,"更新失败"),
    ORDER_DETAIL_EMPTY(16,"订单详情为空"),
    ORDER_PAY_ERROR(17,"订单支付状态不正确"),
     CART_EMPTY(18,"购物车不能为空"),
    ORDER_OWNER_ERROR(19,"错误订单"),
    WECHAT_MP_ERROR(20,"微信公众号方面错误"),
    WXPAY_NOTIFY_MONEY_VERIFY_ERROR(21,"微信异步通知金额不一致"),
    ORDER_FINISH_ERROR(22,"订单完结异常"),
    PRODUCT_STATUS_ERROR(23,"商品状态不正常"),
    LOGIN_FAILL(24,"登录失败"),
    LOGOUT_SUCCESS(25,"登出成功"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
