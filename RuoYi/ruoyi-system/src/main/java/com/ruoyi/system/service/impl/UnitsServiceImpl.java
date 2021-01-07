package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UnitsMapper;
import com.ruoyi.system.domain.Units;
import com.ruoyi.system.service.IUnitsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 单位管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Service
public class UnitsServiceImpl implements IUnitsService 
{
    @Autowired
    private UnitsMapper unitsMapper;

    /**
     * 查询单位管理
     * 
     * @param id 单位管理ID
     * @return 单位管理
     */
    @Override
    public Units selectUnitsById(Long id)
    {
        return unitsMapper.selectUnitsById(id);
    }

    /**
     * 查询单位管理列表
     * 
     * @param units 单位管理
     * @return 单位管理
     */
    @Override
    public List<Units> selectUnitsList(Units units)
    {
        return unitsMapper.selectUnitsList(units);
    }

    /**
     * 新增单位管理
     * 
     * @param units 单位管理
     * @return 结果
     */
    @Override
    public int insertUnits(Units units)
    {
        return unitsMapper.insertUnits(units);
    }

    /**
     * 修改单位管理
     * 
     * @param units 单位管理
     * @return 结果
     */
    @Override
    public int updateUnits(Units units)
    {
        return unitsMapper.updateUnits(units);
    }

    /**
     * 删除单位管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUnitsByIds(String ids)
    {
        return unitsMapper.deleteUnitsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除单位管理信息
     * 
     * @param id 单位管理ID
     * @return 结果
     */
    @Override
    public int deleteUnitsById(Long id)
    {
        return unitsMapper.deleteUnitsById(id);
    }
}
