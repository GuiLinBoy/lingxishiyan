package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * antibody对象 antibody
 * 
 * @author ruoyi
 * @date 2021-01-25
 */
public class Antibody extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 抗体试剂 */
    private Long id;

    /** 登记信息id */
    @Excel(name = "登记信息id")
    private Long registerId;

    /**  */
    @Excel(name = "")
    private String antibodyType;

    /** 示踪标签 */
    @Excel(name = "示踪标签")
    private String tracerTag;

    /** 种属来源 */
    @Excel(name = "种属来源")
    private String sourcesSpices;

    /**  */
    private Integer orderIf;

    /**  */
    private Integer deleteFlag;

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
    public void setAntibodyType(String antibodyType) 
    {
        this.antibodyType = antibodyType;
    }

    public String getAntibodyType() 
    {
        return antibodyType;
    }
    public void setTracerTag(String tracerTag) 
    {
        this.tracerTag = tracerTag;
    }

    public String getTracerTag() 
    {
        return tracerTag;
    }
    public void setSourcesSpices(String sourcesSpices) 
    {
        this.sourcesSpices = sourcesSpices;
    }

    public String getSourcesSpices() 
    {
        return sourcesSpices;
    }
    public void setOrderIf(Integer orderIf) 
    {
        this.orderIf = orderIf;
    }

    public Integer getOrderIf() 
    {
        return orderIf;
    }
    public void setDeleteFlag(Integer deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDeleteFlag() 
    {
        return deleteFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("registerId", getRegisterId())
            .append("antibodyType", getAntibodyType())
            .append("tracerTag", getTracerTag())
            .append("sourcesSpices", getSourcesSpices())
            .append("orderIf", getOrderIf())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
