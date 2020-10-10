package com.dao;

import com.entity.Payment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PaymentMapper {
    List<Payment> getAllPayments();
    Payment getPaymentById(String id);
    int save(Payment payment);
}
