package com.spnc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @desc:
 * @author: zh_haining
 * @date: 2021/6/8 下午3:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderService8201 {
    public static void main(String[] args) {
        SpringApplication.run(OrderService8201.class, args);
    }
}
