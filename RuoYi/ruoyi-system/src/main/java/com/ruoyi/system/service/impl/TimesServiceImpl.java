package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Times;
import com.ruoyi.system.mapper.TimesMapper;
import com.ruoyi.system.service.ITimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 时间Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-14
 */
@Service
public class TimesServiceImpl implements ITimesService 
{
    @Autowired
    private TimesMapper timesMapper;

    /**
     * 查询时间
     * 
     * @param id 时间ID
     * @return 时间
     */
    @Override
    public Times selectTimesById(Long id)
    {
        return timesMapper.selectTimesById(id);
    }

    /**
     * 查询时间列表
     * 
     * @param times 时间
     * @return 时间
     */
    @Override
    public List<Times> selectTimesList(Times times)
    {
        return timesMapper.selectTimesList(times);
    }

    /**
     * 新增时间
     * 
     * @param times 时间
     * @return 结果
     */
    @Override
    public int insertTimes(Times times)
    {
        return timesMapper.insertTimes(times);
    }

    /**
     * 修改时间
     * 
     * @param times 时间
     * @return 结果
     */
    @Override
    public int updateTimes(Times times)
    {
        return timesMapper.updateTimes(times);
    }

    /**
     * 删除时间对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTimesByIds(String ids)
    {
        return timesMapper.deleteTimesByIds(Convert.toStrArray(ids));
    }


    @Override
    public int saveAndUpdateTimes(Times times) {
        if (times.getId() != null) {
            return this.updateTimes(times);
        }else return this.insertTimes(times);
    }

    @Override
    public Times selectTimesByUserId(Integer userId) {
        return timesMapper.selectTimesByUserId(userId);
    }

    /**
     * 删除时间信息
     * 
     * @param id 时间ID
     * @return 结果
     */
    @Override
    public int deleteTimesById(Long id)
    {
        return timesMapper.deleteTimesById(id);
    }
}
