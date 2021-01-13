package com.ruoyi.web.controller.weChat;

import com.ruoyi.system.domain.OrderAndSanFang;
import com.ruoyi.system.domain.OrderInfo;
import com.ruoyi.system.service.IOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Author ZhangGY
 * @Date 2021/1/13 15:45
 **/
@RestController
@RequestMapping("/weChat")
public class OrderController {

    @Autowired
    private IOrderInfoService orderService;


    @ResponseBody
    @RequestMapping("/findOrderByCheckUser")
    public OrderInfo findOrderByCheckUser(Integer checkUserId){
        return orderService.selectOrderInfoByCheckUserId(checkUserId);
    }

    @ResponseBody
    @RequestMapping("/selectOrderInfoByOrderUser")
    public OrderInfo selectOrderInfoByOrderUser(Integer OrderUserId){
        return orderService.selectOrderInfoByOrderUserId(OrderUserId);
    }

    /**
     * @Author ZhangGY
     * @Description //TODO 保存订单和三方信息，一张订单可能有多张三方信息
     * @Date 15:59 2021/1/13
     * @Param [orderAndSanFang]
     * @return
     **/
    @ResponseBody
    @RequestMapping("/saveAndUpdateOrder")
    public int saveAndUpdateOrder(@RequestBody OrderAndSanFang orderAndSanFang){
        if (orderAndSanFang != null) {
            return orderService.saveAndUpdateOrder(orderAndSanFang);
        }else return -1;
    }
}
