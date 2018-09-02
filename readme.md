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