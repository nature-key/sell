package com.springboot.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellApplicationTests {

    @Test
    public void contextLoads() {
        String name = "wangxuan";
        String password = "12345";
        log.error(" name {} ,password {}", name, password);
        log.warn("name {} ,password {}", name, password);
        log.info("name {} ,password {}", name, password);
        log.debug("name {} ,password {}", name, password);
    }

}
