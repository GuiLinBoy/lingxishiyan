package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 研究组管理对象 research_groups
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public class ResearchGroups extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课题组的表 */
    private Long id;

    /** 课题组名(组长名） */
    @Excel(name = "课题组名(组长名）")
    private String researchGroup;

    /** 单位的id */
    @Excel(name = "单位的id")
    private Long unitid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setResearchGroup(String researchGroup) 
    {
        this.researchGroup = researchGroup;
    }

    public String getResearchGroup() 
    {
        return researchGroup;
    }
    public void setUnitid(Long unitid) 
    {
        this.unitid = unitid;
    }

    public Long getUnitid() 
    {
        return unitid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("researchGroup", getResearchGroup())
            .append("unitid", getUnitid())
            .toString();
    }
}
