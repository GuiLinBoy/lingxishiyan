package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserinfoMapper;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.service.IUserinfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 人员管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService 
{
    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * 查询人员管理
     * 
     * @param id 人员管理ID
     * @return 人员管理
     */
    @Override
    public Userinfo selectUserinfoById(Long id)
    {
        return userinfoMapper.selectUserinfoById(id);
    }

    /**
     * 查询人员管理列表
     * 
     * @param userinfo 人员管理
     * @return 人员管理
     */
    @Override
    public List<Userinfo> selectUserinfoList(Userinfo userinfo)
    {
        return userinfoMapper.selectUserinfoList(userinfo);
    }

    /**
     * 新增人员管理
     * 
     * @param userinfo 人员管理
     * @return 结果
     */
    @Override
    public int insertUserinfo(Userinfo userinfo)
    {
        return userinfoMapper.insertUserinfo(userinfo);
    }

    /**
     * 修改人员管理
     * 
     * @param userinfo 人员管理
     * @return 结果
     */
    @Override
    public int updateUserinfo(Userinfo userinfo)
    {
        return userinfoMapper.updateUserinfo(userinfo);
    }

    /**
     * 删除人员管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserinfoByIds(String ids)
    {
        return userinfoMapper.deleteUserinfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除人员管理信息
     * 
     * @param id 人员管理ID
     * @return 结果
     */
    @Override
    public int deleteUserinfoById(Long id)
    {
        return userinfoMapper.deleteUserinfoById(id);
    }
}
