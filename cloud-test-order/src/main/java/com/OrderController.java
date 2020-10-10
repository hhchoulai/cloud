package com;

import com.constant.Constant;
import com.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * 调用payment的接口
 */
@Controller
@Slf4j
public class OrderController {
   @Autowired
   private RestTemplate template;

    @ResponseBody
    @GetMapping("/getPayments")
    public ResultVO getPayments(){
        ResultVO vo = template.getForObject(Constant.PAYMENT_URL + "/list", ResultVO.class);
        return vo;
    }
}
