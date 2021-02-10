package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * animal对象 animal
 * 
 * @author ruoyi
 * @date 2021-01-25
 */
public class Animal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private Long id;

    /**  */
    @Excel(name = "")
    private Long registerId;

    /** 品系 */
    @Excel(name = "品系")
    private String animalType;

    /** 周龄 */
    @Excel(name = "周龄")
    private String age;

    /**  */
    @Excel(name = "")
    private Integer gender;

    /** 只数 */
    @Excel(name = "只数")
    private Integer animalNum;

    /** 寄样地址 */
    @Excel(name = "寄样地址")
    private String address;

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
    public void setAnimalType(String animalType) 
    {
        this.animalType = animalType;
    }

    public String getAnimalType() 
    {
        return animalType;
    }
    public void setAge(String age) 
    {
        this.age = age;
    }

    public String getAge() 
    {
        return age;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }
    public void setAnimalNum(Integer animalNum) 
    {
        this.animalNum = animalNum;
    }

    public Integer getAnimalNum() 
    {
        return animalNum;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
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
            .append("animalType", getAnimalType())
            .append("age", getAge())
            .append("gender", getGender())
            .append("animalNum", getAnimalNum())
            .append("address", getAddress())
            .append("orderIf", getOrderIf())
            .append("deleteFlag", getDeleteFlag())
            .toString();
    }
}
