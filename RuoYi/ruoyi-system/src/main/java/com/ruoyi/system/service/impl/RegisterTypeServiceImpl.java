package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.RegisterType;
import com.ruoyi.system.mapper.RegisterTypeMapper;
import com.ruoyi.system.service.IRegisterTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 登记类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
@Service
public class RegisterTypeServiceImpl implements IRegisterTypeService 
{
    @Autowired
    private RegisterTypeMapper registerTypeMapper;

    /**
     * 查询登记类型
     * 
     * @param id 登记类型ID
     * @return 登记类型
     */
    @Override
    public RegisterType selectRegisterTypeById(Long id)
    {
        return registerTypeMapper.selectRegisterTypeById(id);
    }

    /**
     * 查询登记类型列表
     * 
     * @param registerType 登记类型
     * @return 登记类型
     */
    @Override
    public List<RegisterType> selectRegisterTypeList(RegisterType registerType)
    {
        return registerTypeMapper.selectRegisterTypeList(registerType);
    }

    /**
     * 新增登记类型
     * 
     * @param registerType 登记类型
     * @return 结果
     */
    @Override
    public int insertRegisterType(RegisterType registerType)
    {
        return registerTypeMapper.insertRegisterType(registerType);
    }

    /**
     * 修改登记类型
     * 
     * @param registerType 登记类型
     * @return 结果
     */
    @Override
    public int updateRegisterType(RegisterType registerType)
    {
        return registerTypeMapper.updateRegisterType(registerType);
    }

    /**
     * 删除登记类型对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRegisterTypeByIds(String ids)
    {
        return registerTypeMapper.deleteRegisterTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除登记类型信息
     * 
     * @param id 登记类型ID
     * @return 结果
     */
    @Override
    public int deleteRegisterTypeById(Long id)
    {
        return registerTypeMapper.deleteRegisterTypeById(id);
    }
}
