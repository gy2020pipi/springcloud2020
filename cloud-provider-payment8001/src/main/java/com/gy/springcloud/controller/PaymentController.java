package com.gy.springcloud.controller;

import com.gy.springcloud.entities.CommonResult;
import com.gy.springcloud.entities.Payment;
import com.gy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author gaoyue
 * @create 2020-07-01 17:41
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;



    @PostMapping("/create")
    public CommonResult create( @RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果：" + result);
        if(result > 0){
            return new CommonResult(200, "插入数据库成功",result);
        } else {
            return new CommonResult(444, "插入数据库失败",null);
        }
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("******查询结果：" + payment);
        if(payment != null){
            return new CommonResult(200, "查询数据库成功",payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询的ID：" + id,null);
        }
    }


}
