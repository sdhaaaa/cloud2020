package com.hui.springcloud.controller;

import com.hui.springcloud.entities.CommonResult;
import com.hui.springcloud.entities.Payment;
import com.hui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("Payment")
public class PaymentController {

    private String serverPort="8002";

    final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {

        int result = paymentService.create(payment);
        if (result > 0){
            return new CommonResult(200,"插入数据库成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult(100,"插入数据库失败",null);
        }
    }
    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentId(id);
        if (payment != null){
            return new CommonResult(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult(100,"没有对应数据",null);
        }
    }
}
