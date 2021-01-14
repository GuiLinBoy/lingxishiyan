package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 时间对象 times
 * 
 * @author ruoyi
 * @date 2021-01-14
 */
public class Times extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自定义计时时间 */
    private Long id;

    /** 自定义时间存储以秒来存储 */
    @Excel(name = "自定义时间存储以秒来存储")
    private Long timeLenght;

    /** 自定义该时间的用户 */
    @Excel(name = "自定义该时间的用户")
    private Long userid;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTimeLenght(Long timeLenght) 
    {
        this.timeLenght = timeLenght;
    }

    public Long getTimeLenght() 
    {
        return timeLenght;
    }
    public void setUserid(Long userid) 
    {
        this.userid = userid;
    }

    public Long getUserid() 
    {
        return userid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("timeLenght", getTimeLenght())
            .append("userid", getUserid())
            .toString();
    }
}
