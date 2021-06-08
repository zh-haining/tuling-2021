package com.spnc.controller;

import com.spnc.entities.CommonResult;
import com.spnc.entities.Payment;
import com.spnc.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: zh_haining
 * @date: 2021/6/8 下午3:45
 */
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/get/{id}")
    public CommonResult<Payment> getPaymentInfoById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentInfoById(id);
        return new CommonResult(200, "success", payment);
    }

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i > 0) {
            return new CommonResult(200, "success");
        } else {
            return new CommonResult(500, "fail");
        }
    }
}
