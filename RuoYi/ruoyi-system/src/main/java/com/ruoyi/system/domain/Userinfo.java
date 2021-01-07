package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人员管理对象 userinfo
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public class Userinfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户信息表 */
    private Long id;

    /** 微信官方返回的openid */
    private String openid;

    /** 微信名称 */
    @Excel(name = "微信名称")
    private String wechatname;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String realname;

    /** 工作单位，详情见单位表 */
    @Excel(name = "工作单位，详情见单位表")
    private Long unitid;

    /** 课题组 */
    @Excel(name = "课题组")
    private Long researchGroupId;

    /**  */
    @Excel(name = "")
    private Long jurisdiction;

    /** 职位,三种职位对应着三种不同的权限，prof,teacher,student */
    @Excel(name = "职位,三种职位对应着三种不同的权限，prof,teacher,student")
    private String position;

    /**  */
    @Excel(name = "")
    private String studentSchool;

    /**  */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "", width = 30, dateFormat = "yyyy-MM-dd")
    private Date studentCometime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setWechatname(String wechatname) 
    {
        this.wechatname = wechatname;
    }

    public String getWechatname() 
    {
        return wechatname;
    }
    public void setRealname(String realname) 
    {
        this.realname = realname;
    }

    public String getRealname() 
    {
        return realname;
    }
    public void setUnitid(Long unitid) 
    {
        this.unitid = unitid;
    }

    public Long getUnitid() 
    {
        return unitid;
    }
    public void setResearchGroupId(Long researchGroupId) 
    {
        this.researchGroupId = researchGroupId;
    }

    public Long getResearchGroupId() 
    {
        return researchGroupId;
    }
    public void setJurisdiction(Long jurisdiction) 
    {
        this.jurisdiction = jurisdiction;
    }

    public Long getJurisdiction() 
    {
        return jurisdiction;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setStudentSchool(String studentSchool) 
    {
        this.studentSchool = studentSchool;
    }

    public String getStudentSchool() 
    {
        return studentSchool;
    }
    public void setStudentCometime(Date studentCometime) 
    {
        this.studentCometime = studentCometime;
    }

    public Date getStudentCometime() 
    {
        return studentCometime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("openid", getOpenid())
            .append("wechatname", getWechatname())
            .append("realname", getRealname())
            .append("unitid", getUnitid())
            .append("researchGroupId", getResearchGroupId())
            .append("jurisdiction", getJurisdiction())
            .append("position", getPosition())
            .append("studentSchool", getStudentSchool())
            .append("studentCometime", getStudentCometime())
            .toString();
    }
}
