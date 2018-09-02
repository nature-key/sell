package com.springboot.sell.dto;

import com.springboot.sell.dataobject.OrderDetail;
import com.springboot.sell.enums.OrderStatus;
import com.springboot.sell.enums.PayStatus;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@Entity
@Data
public class OrderDTO {
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    //默认新下单
    private Integer orderStatus= OrderStatus.NEW.getCode();
    //默认的等待支付
    private Integer payStatus= PayStatus.WAIT.getCode();

    private Date createTime;
    private Date updateTime;
    @Transient
    private List<OrderDetail> orderDetailList;
}
