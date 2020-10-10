package com;

import com.entity.Payment;
import com.service.PaymentService;
import com.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @ResponseBody
    @GetMapping("/list")
    public ResultVO list(){
       return paymentService.getAllPayments();
    }

    @ResponseBody
    @GetMapping("/getPaymentById")
    public ResultVO getPaymentById(String id){
       return paymentService.getPaymentById(id);
    }

    @ResponseBody
    @GetMapping("/save")
    public ResultVO save(Payment payment){
        return paymentService.save(payment);
    }

}
