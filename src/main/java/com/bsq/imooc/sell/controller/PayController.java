package com.bsq.imooc.sell.controller;

import com.bsq.imooc.sell.dto.OrderDTO;
import com.bsq.imooc.sell.enums.ResultEnum;
import com.bsq.imooc.sell.exception.SellException;
import com.bsq.imooc.sell.service.OrderService;
import com.bsq.imooc.sell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1. 获的微信用户的openid查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2. 用户下单后发起支付，拉起微信的支付软件
        PayResponse payResponse = payService.create(orderDTO);

        map.put("payResponse", payResponse);
        map.put("returnUrl", returnUrl);

        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);

        //返回给微信处理结果
        return new ModelAndView("pay/success");
    }

}
