package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * upload_pic对象 order_pic
 * 
 * @author ruoyi
 * @date 2021-01-25
 */
public class OrderPic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公共试剂图片上传 */
    private Long id;

    /**  */
    @Excel(name = "")
    private Long orderId;

    /**  */
    @Excel(name = "")
    private String url;

    /**  */
    @Excel(name = "")
    private String fileName;

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
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
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
            .append("orderId", getOrderId())
            .append("url", getUrl())
            .append("fileName", getFileName())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
