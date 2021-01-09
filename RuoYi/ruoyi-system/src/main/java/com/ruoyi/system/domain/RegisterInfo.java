package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 登记信息对象 register_info
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
public class RegisterInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 等级具体信息 */
    private Long id;

    /** 登记名称 */
    @Excel(name = "登记名称")
    private String reagentName;

    /** 制造商 */
    @Excel(name = "制造商")
    private String manufacturer;

    /** 经销商 */
    @Excel(name = "经销商")
    private String dealer;

    /** 货号 */
    @Excel(name = "货号")
    private String goodsid;

    /** 存量情况；0充足，1尚可，2不足 */
    @Excel(name = "存量情况；0充足，1尚可，2不足")
    private Long stockstate;

    /** 实验用途 */
    @Excel(name = "实验用途")
    private String experimentuse;

    /** 保管人 */
    @Excel(name = "保管人")
    private Long preserver;

    /** 订购时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "订购时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date orderTimes;

    /** 登记人 */
    @Excel(name = "登记人")
    private Long registerUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setReagentName(String reagentName) 
    {
        this.reagentName = reagentName;
    }

    public String getReagentName() 
    {
        return reagentName;
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
    public void setPreserver(Long preserver) 
    {
        this.preserver = preserver;
    }

    public Long getPreserver() 
    {
        return preserver;
    }
    public void setOrderTimes(Date orderTimes) 
    {
        this.orderTimes = orderTimes;
    }

    public Date getOrderTimes() 
    {
        return orderTimes;
    }
    public void setRegisterUser(Long registerUser) 
    {
        this.registerUser = registerUser;
    }

    public Long getRegisterUser() 
    {
        return registerUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("reagentName", getReagentName())
            .append("manufacturer", getManufacturer())
            .append("dealer", getDealer())
            .append("goodsid", getGoodsid())
            .append("stockstate", getStockstate())
            .append("experimentuse", getExperimentuse())
            .append("preserver", getPreserver())
            .append("orderTimes", getOrderTimes())
            .append("registerUser", getRegisterUser())
            .toString();
    }
}
