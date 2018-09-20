##微信点餐
   #8.29
   
     1.坑
       问题：SpringBoot错误】【关于：Table 'XXX.hibernate_sequence' doesn't exist】
       解决：将ID生成略组改成@GeneratedValue(strategy = GenerationType.IDENTITY).
     2.工具
       添加依赖
       <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
       </dependency>
       
       使用@Data 省略GET SET 
     3.springboot2
       new PageRequest(0, 2)废弃 替换 静态of方法
       根据ID查询使用的方法是:Optional<T> findById(ID id)-->T t = Optional<T>.get();
       Optional<T>是非null的,但是如果查不到的话,它的get方法会报错,no value present;
       所以在进行get之前,需要使用Optional.isPresent()方法进行判断  
     4.大坑
      解决Java程序连接不上MySQL 但是Navicat可以连接的问题!
      http://binux.cn/2017/03/02/Mac-MySQL-Error/ 
     5.第三方SDK
      weixin-java-tools  
     6.抓包工具
       window figgler
       mac charles 
     7.手机跳转
       sell.com---->浏览器---->到list---->授权--->跳转userinfo-->首页sell.com--->list  
     8.支付sdk
       best-pay-sdk
     9.域名无法访问(注意)
       nginx 没有修改域名
       vim  /usr/local/nginx/conf/nginx.conf
     10 修改配置/opt/code/sell_fe_buyer/config/opt/code/sell_fe_buyer/
        npm run build
        Cp -r dist/* /opt/data/wwwroot/sell/
     11.启动natapp
     ./natapp -authtoken=6da7bdba24c6941
     12.html 
     http://www.ibootstrap.cn/   
         
       
          