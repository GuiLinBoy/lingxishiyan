package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * cell对象 cell
 * 
 * @author ruoyi
 * @date 2021-01-25
 */
public class Cell extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private Long registerId;

    /** 种属来源 */
    @Excel(name = "种属来源")
    private String sourcesSpices;

    /** 来源 */
    @Excel(name = "来源")
    private String sources;

    /** 现存状态 */
    @Excel(name = "现存状态")
    private String existState;

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
    public void setSourcesSpices(String sourcesSpices) 
    {
        this.sourcesSpices = sourcesSpices;
    }

    public String getSourcesSpices() 
    {
        return sourcesSpices;
    }
    public void setSources(String sources) 
    {
        this.sources = sources;
    }

    public String getSources() 
    {
        return sources;
    }
    public void setExistState(String existState) 
    {
        this.existState = existState;
    }

    public String getExistState() 
    {
        return existState;
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
            .append("sourcesSpices", getSourcesSpices())
            .append("sources", getSources())
            .append("existState", getExistState())
            .append("deleteFlag", getDeleteFlag())
            .append("orderIf", getOrderIf())
            .toString();
    }
}
