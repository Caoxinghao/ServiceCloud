package com.xinghao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 曹星皓
 * 2019/11/16 15:17
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.xinghao.cloud"})
@ComponentScan(basePackages = {"com.xinghao.cloud"})
public class DeptConsumer81_Feign_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer81_Feign_App.class,args);
    }
}
