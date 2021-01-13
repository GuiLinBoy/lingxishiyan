package com.ruoyi.system.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;

/**
 * sanFangInfo对象 sanfang_info
 * 
 * @author ruoyi
 * @date 2021-01-13
 */
public class SanfangInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 三方对比表 */
    private Integer id;

    /** 订单id */
    @Excel(name = "订单id")
    private Integer orderid;

    /** 供货商 */
    @Excel(name = "供货商")
    private String dealer;

    /** 数量 */
    @Excel(name = "数量")
    private Long count;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 0表示确定选择；1表示不确定选择 */
    @Excel(name = "0表示确定选择；1表示不确定选择")
    private Long state;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setOrderid(Integer orderid) 
    {
        this.orderid = orderid;
    }

    public Integer getOrderid() 
    {
        return orderid;
    }
    public void setDealer(String dealer) 
    {
        this.dealer = dealer;
    }

    public String getDealer() 
    {
        return dealer;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setState(Long state) 
    {
        this.state = state;
    }

    public Long getState() 
    {
        return state;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderid", getOrderid())
            .append("dealer", getDealer())
            .append("count", getCount())
            .append("price", getPrice())
            .append("state", getState())
            .toString();
    }
}
