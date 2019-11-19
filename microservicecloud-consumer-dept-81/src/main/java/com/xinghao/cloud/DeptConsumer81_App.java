package com.xinghao.cloud;

import com.xinghao.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 曹星皓
 * 2019/11/16 15:17
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "MICROSERVICECLOUD-DEPT",configuration = MySelfRule.class)
public class DeptConsumer81_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer81_App.class,args);
    }
}
