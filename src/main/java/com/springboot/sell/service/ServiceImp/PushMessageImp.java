package com.springboot.sell.service.ServiceImp;

import com.springboot.sell.dto.OrderDTO;
import com.springboot.sell.service.PushMessage;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class PushMessageImp implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        try {
            templateMessage.setTemplateId("im__xvMqdlX2vXww3MORqaXnGP_C2jUmqeCJ8A5h_jk");
            templateMessage.setToUser("gh_8c763529c702");

            List<WxMpTemplateData> data = Arrays.asList(
                    new WxMpTemplateData("first", "亲，记得收货"),
                    new WxMpTemplateData("name", "微信点餐"),
                    new WxMpTemplateData("phone", "15712363915"),
                    new WxMpTemplateData("orderid", orderDTO.getOrderId()),
                    new WxMpTemplateData("status", orderDTO.getOrderStatusEnum().getMessage()),
                    new WxMpTemplateData("amount", "￥" + orderDTO.getOrderAmount()),
                    new WxMpTemplateData("remark", "欢迎再次光临"));
            templateMessage.setData(data);


            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            log.error("【微信模板消息】发送失败，{}", e);
        }


    }
}
