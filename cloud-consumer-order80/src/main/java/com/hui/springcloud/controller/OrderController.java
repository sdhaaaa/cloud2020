package com.hui.springcloud.controller;

import com.hui.springcloud.entities.CommonResult;
import com.hui.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping("consumer")
public class OrderController {
    //public static  String PAYMENT_URL = "http://127.0.0.1:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PROVIDER-SERVICE";

    final RestTemplate restTemplate;

    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/Payment/create")
    public CommonResult<Payment> create(Payment payment){
        System.out.println(payment);
        return restTemplate.postForObject(PAYMENT_URL + "/Payment/create",payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        System.out.println("aaa"+PAYMENT_URL + "/Payment/get/"+id);
        return restTemplate.getForObject(PAYMENT_URL + "/Payment/get/"+id, CommonResult.class);
    }
}
