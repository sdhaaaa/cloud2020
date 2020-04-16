package com.hui.springcloud.service;

import com.hui.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    public  int create(Payment payment);

    public Payment getPaymentId(Long id);
}
