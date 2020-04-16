package com.hui.springcloud.controller;

import com.hui.springcloud.entities.CommonResult;
import com.hui.springcloud.entities.Payment;
import com.hui.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("Payment")
public class PaymentController {


    private String serverPort="8001";

    final PaymentService paymentService;

    final DiscoveryClient discoveryClient;

    public PaymentController(PaymentService paymentService, DiscoveryClient discoveryClient) {
        this.paymentService = paymentService;
        this.discoveryClient = discoveryClient;
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

    @GetMapping(value = "/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();  //得到所有的微服务
        for (String element : services) {
            log.info("*****element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-SERVICE"); //得到一个具体微服务的所有实例
        for (ServiceInstance instance : instances){
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}
