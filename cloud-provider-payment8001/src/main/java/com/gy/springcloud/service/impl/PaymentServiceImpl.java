package com.gy.springcloud.service.impl;

import com.gy.springcloud.dao.PaymentDao;
import com.gy.springcloud.entities.Payment;
import com.gy.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author gaoyue
 * @create 2020-07-01 17:14
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
