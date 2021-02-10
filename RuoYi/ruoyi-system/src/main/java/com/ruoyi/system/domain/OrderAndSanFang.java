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
    private List<OrderInfo> orderInfoList;

    private Antibody     antibody;
    private Plasmid      plasmid;
    private Cell         cell;
    private Microbial   microbial;
    private Animal     animal;

    private OrderPic orderPic;

    public OrderPic getOrderPic() {
        return orderPic;
    }

    public void setOrderPic(OrderPic orderPic) {
        this.orderPic = orderPic;
    }

    public Antibody getAntibody() {
        return antibody;
    }

    public void setAntibody(Antibody antibody) {
        this.antibody = antibody;
    }

    public Plasmid getPlasmid() {
        return plasmid;
    }

    public void setPlasmid(Plasmid plasmid) {
        this.plasmid = plasmid;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public Microbial getMicrobial() {
        return microbial;
    }

    public void setMicrobial(Microbial microbial) {
        this.microbial = microbial;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public List<OrderInfo> getOrderInfoList() {
        return orderInfoList;
    }

    public void setOrderInfoList(List<OrderInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }

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
