package com.springboot.sell.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.springboot.sell.dataobject.OrderDetail;
import com.springboot.sell.enums.OrderStatus;
import com.springboot.sell.enums.PayStatus;
import com.springboot.sell.utils.EnumUtil;
import com.springboot.sell.utils.serializer.DataToLogSerializer;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@Entity
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    //默认新下单
    private Integer orderStatus = OrderStatus.NEW.getCode();
    //默认的等待支付
    private Integer payStatus = PayStatus.WAIT.getCode();
    @JsonSerialize(using = DataToLogSerializer.class)
    private Date createTime;
    @JsonSerialize(using = DataToLogSerializer.class)
    private Date updateTime;
    @Transient
    private List<OrderDetail> orderDetailList;

    @JsonIgnore  //转成json忽略字段
    public OrderStatus getOrderStatusEnum() {

        return EnumUtil.getByCode(orderStatus, OrderStatus.class);
    }

    @JsonIgnore
    public PayStatus getPayStatusEnum() {

        return EnumUtil.getByCode(payStatus, PayStatus.class);

    }
}
