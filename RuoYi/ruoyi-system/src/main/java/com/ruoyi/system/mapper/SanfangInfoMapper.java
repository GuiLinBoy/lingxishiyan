package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SanfangInfo;

/**
 * sanFangInfoMapper接口
 * 
 * @author ruoyi
 * @date 2021-01-13
 */
public interface SanfangInfoMapper 
{
    /**
     * 查询sanFangInfo
     * 
     * @param id sanFangInfoID
     * @return sanFangInfo
     */
    public SanfangInfo selectSanfangInfoById(Integer id);

    /**
     * 查询sanFangInfo列表
     * 
     * @param sanfangInfo sanFangInfo
     * @return sanFangInfo集合
     */
    public List<SanfangInfo> selectSanfangInfoList(SanfangInfo sanfangInfo);

    /**
     * 新增sanFangInfo
     * 
     * @param sanfangInfo sanFangInfo
     * @return 结果
     */
    public int insertSanfangInfo(SanfangInfo sanfangInfo);

    /**
     * 修改sanFangInfo
     * 
     * @param sanfangInfo sanFangInfo
     * @return 结果
     */
    public int updateSanfangInfo(SanfangInfo sanfangInfo);

    /**
     * 删除sanFangInfo
     * 
     * @param id sanFangInfoID
     * @return 结果
     */
    public int deleteSanfangInfoById(Integer id);

    /**
     * 批量删除sanFangInfo
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSanfangInfoByIds(String[] ids);
}
