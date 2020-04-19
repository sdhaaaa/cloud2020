package com.hui.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentController {
    private String serverPort="8006";

    @GetMapping(value = "/payment/consul")
    public String paymentzk(){
        return "springcloud with consul："+serverPort+"\t"+ UUID.randomUUID().toString();
    }
}
