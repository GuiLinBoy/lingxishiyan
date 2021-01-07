package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * j记事本对象 notepad
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public class Notepad extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记事本 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userid;

    /** 实验名称 */
    @Excel(name = "实验名称")
    private String experimentName;

    /** 所需试剂、货号、供应商 */
    @Excel(name = "所需试剂、货号、供应商")
    private String description1;

    /** 所需仪器名称、类型、商家 */
    @Excel(name = "所需仪器名称、类型、商家")
    private String description2;

    /** 具体内容 */
    @Excel(name = "具体内容")
    private String description3;

    /** 步骤 */
    @Excel(name = "步骤")
    private Integer steps;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }
    public void setExperimentName(String experimentName) 
    {
        this.experimentName = experimentName;
    }

    public String getExperimentName() 
    {
        return experimentName;
    }
    public void setDescription1(String description1) 
    {
        this.description1 = description1;
    }

    public String getDescription1() 
    {
        return description1;
    }
    public void setDescription2(String description2) 
    {
        this.description2 = description2;
    }

    public String getDescription2() 
    {
        return description2;
    }
    public void setDescription3(String description3) 
    {
        this.description3 = description3;
    }

    public String getDescription3() 
    {
        return description3;
    }
    public void setSteps(Integer steps) 
    {
        this.steps = steps;
    }

    public Integer getSteps() 
    {
        return steps;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userid", getUserid())
            .append("experimentName", getExperimentName())
            .append("description1", getDescription1())
            .append("description2", getDescription2())
            .append("description3", getDescription3())
            .append("steps", getSteps())
            .toString();
    }
}
