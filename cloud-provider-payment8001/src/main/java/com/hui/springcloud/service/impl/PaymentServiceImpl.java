package com.hui.springcloud.service.impl;

import com.hui.springcloud.dao.PaymentDao;
import com.hui.springcloud.entities.Payment;
import com.hui.springcloud.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    public PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentId(Long id) {
        return paymentDao.getPaymentId(id);
    }
}
