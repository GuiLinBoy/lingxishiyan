package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Units;

/**
 * 单位管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public interface IUnitsService 
{
    /**
     * 查询单位管理
     * 
     * @param id 单位管理ID
     * @return 单位管理
     */
    public Units selectUnitsById(Long id);

    /**
     * 查询单位管理列表
     * 
     * @param units 单位管理
     * @return 单位管理集合
     */
    public List<Units> selectUnitsList(Units units);

    /**
     * 新增单位管理
     * 
     * @param units 单位管理
     * @return 结果
     */
    public int insertUnits(Units units);

    /**
     * 修改单位管理
     * 
     * @param units 单位管理
     * @return 结果
     */
    public int updateUnits(Units units);

    /**
     * 批量删除单位管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUnitsByIds(String ids);

    /**
     * 删除单位管理信息
     * 
     * @param id 单位管理ID
     * @return 结果
     */
    public int deleteUnitsById(Long id);
}
