package com.hui.springcloud.dao;

import com.hui.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    public  int create(Payment payment);

    public Payment getPaymentId(@Param("id") Long id);
}
