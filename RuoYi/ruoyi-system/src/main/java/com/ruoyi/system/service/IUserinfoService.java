package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Userinfo;

/**
 * 人员管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public interface IUserinfoService 
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
     * 批量删除人员管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserinfoByIds(String ids);

    /**
     * 删除人员管理信息
     * 
     * @param id 人员管理ID
     * @return 结果
     */
    public int deleteUserinfoById(Long id);

    /**
     * @Author ZhangGY
     * @Description //TODO根据openID查询列表
     * @Date 18:12 2021/1/7
     * @Param
     * @return
     **/
    Userinfo selectUserinfoByOpenId(String openId);
}
