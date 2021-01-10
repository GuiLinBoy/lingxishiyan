package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 人员管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Mapper
public interface UserinfoMapper 
{
    /**
     * 查询人员管理
     * 
     * @param id 人员管理ID
     * @return 人员管理
     */
    public Userinfo selectUserinfoById(Long id);

    /**
     * 查询人员管理列表
     * 
     * @param userinfo 人员管理
     * @return 人员管理集合
     */
    public List<Userinfo> selectUserinfoList(Userinfo userinfo);

    /**
     * 新增人员管理
     * 
     * @param userinfo 人员管理
     * @return 结果
     */
    public int insertUserinfo(Userinfo userinfo);

    /**
     * 修改人员管理
     * 
     * @param userinfo 人员管理
     * @return 结果
     */
    public int updateUserinfo(Userinfo userinfo);

    /**
     * 删除人员管理
     * 
     * @param id 人员管理ID
     * @return 结果
     */
    public int deleteUserinfoById(Long id);

    /**
     * 批量删除人员管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserinfoByIds(String[] ids);

    Userinfo selectUserinfoByOpenId(String openId);

    List<Userinfo> selectUserByGroupIdAunitid(@Param("unitid") Integer unitid,@Param("researchGroupId") Integer researchGroupId);
}
