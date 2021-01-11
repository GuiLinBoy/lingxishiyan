package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.mapper.UserinfoMapper;
import com.ruoyi.system.service.IResearchGroupsService;
import com.ruoyi.system.service.IUnitsService;
import com.ruoyi.system.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Autowired
    private IResearchGroupsService researchGroupsService;

    @Autowired
    private IUnitsService unitsService;
    /**
     * 查询人员管理
     * 
     * @param id 人员管理ID
     * @return 人员管理
     */
    @Override
    public Userinfo selectUserinfoById(Long id)
    {
        Userinfo userinfo = userinfoMapper.selectUserinfoById(id);
        String researchGroup = researchGroupsService.selectResearchGroupsById(userinfo.getResearchGroupId()).getResearchGroup();
        userinfo.setResearchGroup(researchGroup);
        String unitName = unitsService.selectUnitsById(userinfo.getUnitid()).getUnitname();
        userinfo.setUnit(unitName);
        return userinfo;
    }


    @Override
    public List<Userinfo> findUserByGroupIdAunitid(Integer unitid, Integer researchGroupId) {
        return userinfoMapper.selectUserByGroupIdAunitid(unitid,researchGroupId);
    }

    @Override
    public List<Userinfo> selectListLikeByRealName(String realName) {
        return userinfoMapper.selectListLikeByRealName(realName);
    }

    @Override
    public List<Userinfo> selectUserinfoList(Userinfo userinfo)
    {
        return userinfoMapper.selectUserinfoList(userinfo);
    }
    /**
     * 查询人员管理列表
     * 
     * @param userinfo 人员管理
     * @return 人员管理
     */
    @Override
    public List<Userinfo> selectUserinfoListTo(Userinfo userinfo)
    {
        List<Userinfo> userinfoList = userinfoMapper.selectUserinfoList(userinfo);

        for (Userinfo info:userinfoList){
            Long unitid = info.getUnitid();
            Long researchGroupId = info.getResearchGroupId();
            String researchGroupName = researchGroupsService.selectResearchGroupsById(researchGroupId).getResearchGroup();
            String unitName = unitsService.selectUnitsById(unitid).getUnitname();
            info.setUnit(unitName);
            info.setResearchGroup(researchGroupName);
        }
        return userinfoList;
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
     * @Author ZhangGY
     * @Description //TODO WeChat更新或插入人员
     * @Date 21:32 2021/1/7
     * @Param
     * @return
     **/
    @Override
    public int insertAndUpdateUserInfo(Userinfo userinfo) {
        if (userinfo.getId() != null)
            return this.updateUserinfo(userinfo);
        else
           return this.insertUserinfo(userinfo);
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

    @Override
    public Userinfo selectUserinfoByOpenId(String openId) {
        return userinfoMapper.selectUserinfoByOpenId(openId);
    }
}
