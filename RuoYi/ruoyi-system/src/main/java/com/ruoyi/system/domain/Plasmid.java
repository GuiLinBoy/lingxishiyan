package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * plasmid对象 plasmid
 * 
 * @author ruoyi
 * @date 2021-01-25
 */
public class Plasmid extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private Long registerId;

    /** 示踪标签 */
    @Excel(name = "示踪标签")
    private String tracerTag;

    /** 来源 */
    @Excel(name = "来源")
    private String sources;

    /** 筛选标签 */
    @Excel(name = "筛选标签")
    private String screenTag;

    /** 物理化学转染方法 */
    @Excel(name = "物理化学转染方法")
    private String traMethod;

    /** 生物转染方法 */
    @Excel(name = "生物转染方法")
    private String chTraMethod;

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
    public void setTracerTag(String tracerTag) 
    {
        this.tracerTag = tracerTag;
    }

    public String getTracerTag() 
    {
        return tracerTag;
    }
    public void setSources(String sources) 
    {
        this.sources = sources;
    }

    public String getSources() 
    {
        return sources;
    }
    public void setScreenTag(String screenTag) 
    {
        this.screenTag = screenTag;
    }

    public String getScreenTag() 
    {
        return screenTag;
    }
    public void setTraMethod(String traMethod) 
    {
        this.traMethod = traMethod;
    }

    public String getTraMethod() 
    {
        return traMethod;
    }
    public void setChTraMethod(String chTraMethod) 
    {
        this.chTraMethod = chTraMethod;
    }

    public String getChTraMethod() 
    {
        return chTraMethod;
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
            .append("tracerTag", getTracerTag())
            .append("sources", getSources())
            .append("screenTag", getScreenTag())
            .append("traMethod", getTraMethod())
            .append("chTraMethod", getChTraMethod())
            .append("deleteFlag", getDeleteFlag())
            .append("orderIf", getOrderIf())
            .toString();
    }
}
