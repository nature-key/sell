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
