package com.service.impl;

import com.constant.Constant;
import com.dao.PaymentMapper;
import com.entity.Payment;
import com.service.PaymentService;
import com.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Value("${server.port}")
    private String port;

    @Override
    public ResultVO getAllPayments() {
        log.info(port+"端口服务调用");
        return ResultVO.success("调用"+port+"服务",paymentMapper.getAllPayments());
    }

    @Override
    public ResultVO getPaymentById(String id) {
        Payment payment = paymentMapper.getPaymentById(id);
        if (payment == null){
            return ResultVO.fail(Constant.FAIL_CODE,"没有此payment");
        }
        return ResultVO.success(payment);
    }

    @Override
    public ResultVO save(Payment payment) {
        int line=paymentMapper.save(payment);
        if (line != 0){
            return ResultVO.success();
        }
        return ResultVO.fail(Constant.FAIL_CODE,"插入失败");
    }
}
