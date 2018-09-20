package com.springboot.sell.controller;

import com.springboot.sell.config.ProjectUrlConfig;
import com.springboot.sell.constant.CookieConstant;
import com.springboot.sell.constant.RedisConstant;
import com.springboot.sell.dataobject.SellerInfo;
import com.springboot.sell.enums.ResultEnum;
import com.springboot.sell.service.SellerService;
import com.springboot.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller")
public class SellUserController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              HttpServletResponse respose,
                              Map<String, Object> map) {
        SellerInfo sellerInfo = sellerService.findSellerByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAILL.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.Expire;
        stringRedisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX,token),openid,expire, TimeUnit.SECONDS );
        CookieUtil.set(respose, CookieConstant.TOKEN,token,CookieConstant.EXPIRE);
        return new ModelAndView("redirect:"+projectUrlConfig.getSell()+"/sell/seller/order/list");
//        return  null;
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletResponse respose,
                               HttpServletRequest request,
                               Map<String,Object> map) {

        Cookie cookie =  CookieUtil.get(request,CookieConstant.TOKEN);
          if(cookie!=null){
              stringRedisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
          }

        CookieUtil.set(respose,CookieConstant.TOKEN,null,0);
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
