package com.spnc.controller;

import com.spnc.entities.CommonResult;
import com.spnc.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @desc:
 * @author: zh_haining
 * @date: 2021/6/8 下午3:25
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/getOrderInfo")
    public CommonResult<Payment> getOrderById() {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        return restTemplate.getForObject("http://" + instances.get(0).getHost() + ":" + instances.get(0).getPort() + "/payment/get/1", CommonResult.class);
    }

    @PostMapping(value = "/create")
    public CommonResult createOrder(@RequestBody Payment payment) {
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        return restTemplate.postForObject("http://" + instances.get(0).getHost() + ":" + instances.get(0).getPort() + "/payment/create", payment, CommonResult.class);
    }

}
