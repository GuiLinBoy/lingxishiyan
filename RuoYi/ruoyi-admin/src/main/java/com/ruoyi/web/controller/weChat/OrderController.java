package com.ruoyi.web.controller.weChat;

import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.system.domain.OrderAndSanFang;
import com.ruoyi.system.domain.SanfangInfo;
import com.ruoyi.system.service.IOrderInfoService;
import com.ruoyi.system.service.ISanfangInfoService;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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


    @Autowired
    private ISanfangInfoService sanfangInfoService;


    @ResponseBody
    @RequestMapping("/findOrderByCheckUser")
    public  OrderAndSanFang findOrderByCheckUser(Integer checkUserId){
         return orderService.selectOrderInfoByCheckUserId(checkUserId);
    }

    @ResponseBody
    @RequestMapping("/selectOrderInfoByOrderUser")
    public OrderAndSanFang selectOrderInfoByOrderUser(Integer OrderUserId){
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


    @ResponseBody
    @RequestMapping("/findSanFangByOrderId")
    public List<SanfangInfo> findSanFangByOrderId(Integer OrderId){
        if (OrderId != null) {
            return sanfangInfoService.selectSanfangInfoByOrderId(OrderId.longValue());
        }else return null;
    }

    @ResponseBody
    @RequestMapping("/updateCheckState")
    public int updateCheckState(Integer id ,Integer checkState){
        if (id != null && checkState != null){
            return orderService.updateCheckState(id,checkState);
        }else return -1;
    }
}
