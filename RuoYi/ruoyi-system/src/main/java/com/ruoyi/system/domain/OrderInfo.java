package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;
import java.util.Date;

/**
 * orderInfo对象 order_info
 * 
 * @author ruoyi
 * @date 2021-01-13
 */
public class OrderInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订购信息 */
    private Long id;

    /** 0代表个人使用试剂申购；1代表公用试剂、耗材短缺上报及订购 */
    @Excel(name = "0代表个人使用试剂申购；1代表公用试剂、耗材短缺上报及订购")
    private Integer orderType;

    /** 订购名称 */
    @Excel(name = "订购名称")
    private Long orderName;
    private String orderSurname;
    /** 制造商 */
    @Excel(name = "制造商")
    private String manufacturer;

    /** 供货商 */
    @Excel(name = "供货商")
    private String dealer;

    /** 货号 */
    @Excel(name = "货号")
    private String goodsid;

    /** 存量情况；0充足，1尚可，2不足 */
    @Excel(name = "存量情况；0充足，1尚可，2不足")
    private Long stockstate;

    private String specifications;
    /** 实验用途 */
    @Excel(name = "实验用途")
    private String experimentuse;

    /** 订购人 */
    @Excel(name = "订购人")
    private Long orderUser;

    private String orderUserName;

    /** 订购时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "订购时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 报价 */
    @Excel(name = "报价")
    private BigDecimal offerPrice;

    /** 审核状态；0是待审核；1是审核成功；2是审核失败 */
    @Excel(name = "审核状态；0是待审核；1是审核成功；2是审核失败")
    private Integer checkstate;

    /** 审核人id */
    @Excel(name = "审核人id")
    private Long checkUser;

    private String checkUserName;

    /** 0是不加三方1是加上三方 */
    @Excel(name = "0是不加三方1是加上三方")
    private Long sanfang;
    private Integer deleteFlag;

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public String getOrderSurname() {
        return orderSurname;
    }

    public void setOrderSurname(String orderSurname) {
        this.orderSurname = orderSurname;
    }

    public String getOrderUserName() {
        return orderUserName;
    }

    public void setOrderUserName(String orderUserName) {
        this.orderUserName = orderUserName;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderType(Integer orderType) 
    {
        this.orderType = orderType;
    }

    public Integer getOrderType() 
    {
        return orderType;
    }
    public void setOrderName(Long orderName) 
    {
        this.orderName = orderName;
    }

    public Long getOrderName() 
    {
        return orderName;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setDealer(String dealer) 
    {
        this.dealer = dealer;
    }

    public String getDealer() 
    {
        return dealer;
    }
    public void setGoodsid(String goodsid) 
    {
        this.goodsid = goodsid;
    }

    public String getGoodsid() 
    {
        return goodsid;
    }
    public void setStockstate(Long stockstate) 
    {
        this.stockstate = stockstate;
    }

    public Long getStockstate() 
    {
        return stockstate;
    }
    public void setExperimentuse(String experimentuse) 
    {
        this.experimentuse = experimentuse;
    }

    public String getExperimentuse() 
    {
        return experimentuse;
    }
    public void setOrderUser(Long orderUser) 
    {
        this.orderUser = orderUser;
    }

    public Long getOrderUser() 
    {
        return orderUser;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setOfferPrice(BigDecimal offerPrice) 
    {
        this.offerPrice = offerPrice;
    }

    public BigDecimal getOfferPrice() 
    {
        return offerPrice;
    }
    public void setCheckstate(Integer checkstate) 
    {
        this.checkstate = checkstate;
    }

    public Integer getCheckstate() 
    {
        return checkstate;
    }
    public void setCheckUser(Long checkUser) 
    {
        this.checkUser = checkUser;
    }

    public Long getCheckUser() 
    {
        return checkUser;
    }
    public void setSanfang(Long sanfang) 
    {
        this.sanfang = sanfang;
    }

    public Long getSanfang() 
    {
        return sanfang;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderType", getOrderType())
            .append("orderName", getOrderName())
            .append("manufacturer", getManufacturer())
            .append("dealer", getDealer())
            .append("goodsid", getGoodsid())
            .append("stockstate", getStockstate())
            .append("experimentuse", getExperimentuse())
            .append("orderUser", getOrderUser())
            .append("orderTime", getOrderTime())
            .append("offerPrice", getOfferPrice())
            .append("checkstate", getCheckstate())
            .append("checkUser", getCheckUser())
            .append("sanfang", getSanfang())
            .toString();
    }
}
