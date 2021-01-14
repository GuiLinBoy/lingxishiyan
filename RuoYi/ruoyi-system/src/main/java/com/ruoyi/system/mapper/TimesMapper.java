package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Times;

import java.util.List;

/**
 * 时间Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-14
 */
public interface TimesMapper 
{
    /**
     * 查询时间
     * 
     * @param id 时间ID
     * @return 时间
     */
    public Times selectTimesById(Long id);

    /**
     * 查询时间列表
     * 
     * @param times 时间
     * @return 时间集合
     */
    public List<Times> selectTimesList(Times times);

    /**
     * 新增时间
     * 
     * @param times 时间
     * @return 结果
     */
    public int insertTimes(Times times);

    /**
     * 修改时间
     * 
     * @param times 时间
     * @return 结果
     */
    public int updateTimes(Times times);

    /**
     * 删除时间
     * 
     * @param id 时间ID
     * @return 结果
     */
    public int deleteTimesById(Long id);

    /**
     * 批量删除时间
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTimesByIds(String[] ids);

    Times selectTimesByUserId(Integer userId);
}
