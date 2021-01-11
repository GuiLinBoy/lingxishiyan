package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.RegisterType;

import java.util.List;

/**
 * 登记类型Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
public interface RegisterTypeMapper 
{
    /**
     * 查询登记类型
     * 
     * @param id 登记类型ID
     * @return 登记类型
     */
    public RegisterType selectRegisterTypeById(Long id);

    /**
     * 查询登记类型列表
     * 
     * @param registerType 登记类型
     * @return 登记类型集合
     */
    public List<RegisterType> selectRegisterTypeList(RegisterType registerType);

    /**
     * 新增登记类型
     * 
     * @param registerType 登记类型
     * @return 结果
     */
    public int insertRegisterType(RegisterType registerType);

    /**
     * 修改登记类型
     * 
     * @param registerType 登记类型
     * @return 结果
     */
    public int updateRegisterType(RegisterType registerType);

    /**
     * 删除登记类型
     * 
     * @param id 登记类型ID
     * @return 结果
     */
    public int deleteRegisterTypeById(Long id);

    /**
     * 批量删除登记类型
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRegisterTypeByIds(String[] ids);
}
