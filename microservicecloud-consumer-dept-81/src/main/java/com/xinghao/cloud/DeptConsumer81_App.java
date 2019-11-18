package com.xinghao.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 曹星皓
 * 2019/11/16 15:17
 */
@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer81_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer81_App.class,args);
    }
}
