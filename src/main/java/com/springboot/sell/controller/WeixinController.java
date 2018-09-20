package com.springboot.sell.controller;

import com.springboot.sell.utils.CheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {
    @GetMapping("/authtest")
    public void auth(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("success");
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
                out.write(echostr);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    @GetMapping("/authorize")
    public void authorize(@RequestParam("code") String code) {

        log.info("进入/authorize");
        log.info("code={}", code);
        String url ="https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx8f46d2ba8db0c752&secret=30d148af877f8e9c45778ebd03c2d461&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String reponse = restTemplate.getForObject(url,String.class);
        log.info("response={}",reponse);
    }


}
