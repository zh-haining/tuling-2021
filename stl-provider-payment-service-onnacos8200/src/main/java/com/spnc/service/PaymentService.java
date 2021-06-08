package com.spnc.service;

import com.spnc.entities.Payment;
import com.spnc.mapper.PaymentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: zh_haining
 * @date: 2021/6/8 下午3:46
 */
@Service
public class PaymentService {
    @Autowired
    PaymentMapper paymentMapper;

    public Payment getPaymentInfoById(Long id) {
        return paymentMapper.getPaymentById(id);
    }

    public int create(Payment payment) {
        return paymentMapper.create(payment);
    }
}
