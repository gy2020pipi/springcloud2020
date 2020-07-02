package com.gy.springcloud.service;

import com.gy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author gaoyue
 * @create 2020-07-01 17:13
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
