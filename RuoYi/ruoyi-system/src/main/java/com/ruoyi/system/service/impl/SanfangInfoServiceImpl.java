package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SanfangInfoMapper;
import com.ruoyi.system.domain.SanfangInfo;
import com.ruoyi.system.service.ISanfangInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * sanFangInfoService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-13
 */
@Service
public class SanfangInfoServiceImpl implements ISanfangInfoService 
{
    @Autowired
    private SanfangInfoMapper sanfangInfoMapper;

    /**
     * 查询sanFangInfo
     * 
     * @param id sanFangInfoID
     * @return sanFangInfo
     */
    @Override
    public SanfangInfo selectSanfangInfoById(Integer id)
    {
        return sanfangInfoMapper.selectSanfangInfoById(id);
    }

    /**
     * 查询sanFangInfo列表
     * 
     * @param sanfangInfo sanFangInfo
     * @return sanFangInfo
     */
    @Override
    public List<SanfangInfo> selectSanfangInfoList(SanfangInfo sanfangInfo)
    {
        return sanfangInfoMapper.selectSanfangInfoList(sanfangInfo);
    }

    /**
     * 新增sanFangInfo
     * 
     * @param sanfangInfo sanFangInfo
     * @return 结果
     */
    @Override
    public int insertSanfangInfo(SanfangInfo sanfangInfo)
    {
        return sanfangInfoMapper.insertSanfangInfo(sanfangInfo);
    }

    /**
     * 修改sanFangInfo
     * 
     * @param sanfangInfo sanFangInfo
     * @return 结果
     */
    @Override
    public int updateSanfangInfo(SanfangInfo sanfangInfo)
    {
        return sanfangInfoMapper.updateSanfangInfo(sanfangInfo);
    }

    /**
     * 删除sanFangInfo对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteSanfangInfoByIds(String ids)
    {
        return sanfangInfoMapper.deleteSanfangInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除sanFangInfo信息
     * 
     * @param id sanFangInfoID
     * @return 结果
     */
    @Override
    public int deleteSanfangInfoById(Integer id)
    {
        return sanfangInfoMapper.deleteSanfangInfoById(id);
    }
}
