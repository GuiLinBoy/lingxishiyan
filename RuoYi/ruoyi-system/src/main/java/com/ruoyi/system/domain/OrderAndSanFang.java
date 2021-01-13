package com.ruoyi.system.domain;

import java.util.List;

/**
 * @Classname OrderAndSanFang
 * @Author ZhangGY
 * @Date 2021/1/13 15:56
 **/
public class OrderAndSanFang {

    private OrderInfo         orderInfo;
    private List<SanfangInfo> sanFangInfoList;



    public OrderInfo getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(OrderInfo orderInfo) {
        this.orderInfo = orderInfo;
    }

    public List<SanfangInfo> getSanFangInfoList() {
        return sanFangInfoList;
    }

    public void setSanFangInfoList(List<SanfangInfo> sanFangInfoList) {
        this.sanFangInfoList = sanFangInfoList;
    }

    @Override
    public String toString() {
        return "OrderAndSanFang{" +
                "orderInfo=" + orderInfo +
                ", sanFangInfoList=" + sanFangInfoList +
                '}';
    }
}
