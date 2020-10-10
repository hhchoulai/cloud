package com.service;

import com.entity.Payment;
import com.vo.ResultVO;

public interface PaymentService {
    ResultVO getAllPayments();
    ResultVO getPaymentById(String id);
    ResultVO save(Payment payment);
}
