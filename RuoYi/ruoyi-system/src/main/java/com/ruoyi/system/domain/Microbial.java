package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * microbial对象 microbial
 * 
 * @author ruoyi
 * @date 2021-01-25
 */
public class Microbial extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private Long registerId;

    /** 是否耐药 */
    @Excel(name = "是否耐药")
    private Integer durgResist;

    /**  */
    @JsonProperty(value = "ATCC")
    @Excel(name = "")
    private String ATCC;

    /**  */
    @Excel(name = "")
    private String microbialType;

    /**  */
    private Integer deleteFlag;

    /**  */
    private Integer orderIf;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRegisterId(Long registerId) 
    {
        this.registerId = registerId;
    }

    public Long getRegisterId() 
    {
        return registerId;
    }
    public void setDurgResist(Integer durgResist) 
    {
        this.durgResist = durgResist;
    }

    public Integer getDurgResist() 
    {
        return durgResist;
    }
    public void setATCC(String ATCC) 
    {
        this.ATCC = ATCC;
    }

    public String getATCC() 
    {
        return ATCC;
    }
    public void setMicrobialType(String microbialType) 
    {
        this.microbialType = microbialType;
    }

    public String getMicrobialType() 
    {
        return microbialType;
    }
    public void setDeleteFlag(Integer deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDeleteFlag() 
    {
        return deleteFlag;
    }
    public void setOrderIf(Integer orderIf) 
    {
        this.orderIf = orderIf;
    }

    public Integer getOrderIf() 
    {
        return orderIf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("registerId", getRegisterId())
            .append("durgResist", getDurgResist())
            .append("ATCC", getATCC())
            .append("microbialType", getMicrobialType())
            .append("deleteFlag", getDeleteFlag())
            .append("orderIf", getOrderIf())
            .toString();
    }
}
