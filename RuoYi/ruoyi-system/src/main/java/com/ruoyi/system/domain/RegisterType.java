package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 登记类型对象 register_type
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
public class RegisterType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 等级类型 */
    private Long id;

    /**  */
    @Excel(name = "")
    private String registerName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRegisterName(String registerName) 
    {
        this.registerName = registerName;
    }

    public String getRegisterName() 
    {
        return registerName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("registerName", getRegisterName())
            .toString();
    }
}
