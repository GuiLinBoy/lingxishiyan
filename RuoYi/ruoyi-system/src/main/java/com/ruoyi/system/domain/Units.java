package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 单位管理对象 units
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public class Units extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 单位表 */
    private Long id;

    /**  */
    @Excel(name = "")
    private String unitname;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUnitname(String unitname) 
    {
        this.unitname = unitname;
    }

    public String getUnitname() 
    {
        return unitname;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("unitname", getUnitname())
            .toString();
    }
}
