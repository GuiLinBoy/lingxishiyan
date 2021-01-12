package com.ruoyi.system.service.impl;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.ResearchGroups;
import com.ruoyi.system.mapper.ResearchGroupsMapper;
import com.ruoyi.system.service.IResearchGroupsService;
import com.ruoyi.system.service.IUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 课题组管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Service
public class ResearchGroupsServiceImpl implements IResearchGroupsService 
{
    @Autowired
    private ResearchGroupsMapper researchGroupsMapper;

    @Autowired
    private IUnitsService unitsService;
    /**
     * 查询课题组管理
     * 
     * @param id 课题组管理ID
     * @return 课题组管理
     */
    @Override
    public ResearchGroups selectResearchGroupsById(Long id)
    {
        ResearchGroups groups = researchGroupsMapper.selectResearchGroupsById(id);
        String unitname = unitsService.selectUnitsById(groups.getUnitid()).getUnitname();
        groups.setUnitName(unitname);
        return groups;
    }

    /**
     * 查询课题组管理列表
     * 
     * @param researchGroups 课题组管理
     * @return 课题组管理
     */
    @Override
    public List<ResearchGroups> selectResearchGroupsList(ResearchGroups researchGroups)
    {
        return researchGroupsMapper.selectResearchGroupsList(researchGroups);
    }

    @Override
    public Long findAndSaveByName(String researchGroupName, Long unitid) {
        ResearchGroups researchGroups = this.findByName(researchGroupName);
       if (researchGroups == null){
           researchGroups = new ResearchGroups();
           researchGroups.setResearchGroup(researchGroupName);
           researchGroups.setUnitid(unitid);
           this.insertResearchGroups(researchGroups);
       }
        return this.findByName(researchGroupName).getId();
    }

    @Override
    public ResearchGroups findByName(String researchGroupName) {
        if (researchGroupName != null)
           return researchGroupsMapper.selectResearchGroupsByName(researchGroupName);
        else
            return null;
    }

    @Override
    public ResearchGroups findById(Integer groupId) {
        if (groupId != null) {
            return this.selectResearchGroupsById(groupId.longValue());
        }else return null;
    }

    /**
     * @Author ZhangGY
     * @Description //TODO 查询所有课题组（添加单位名称）
     * @Date 21:15 2021/1/11
     * @Param
     * @return
     **/
    @Override
    public List<ResearchGroups> selectResearchGroupsListMy(String researchGroup, String unitName) {
        return researchGroupsMapper.selectResearchGroupsListMy(researchGroup,unitName);
    }

    @Override
    public Long selectMaxId() {
        return researchGroupsMapper.selectMaxId();
    }

    @Override
    public String checkGroupNameUnique(ResearchGroups groups) {

        Long deptId = StringUtils.isNull(groups.getUnitid()) ? -1L : groups.getUnitid();
        ResearchGroups info = researchGroupsMapper.checkGroupNameUnique(groups.getResearchGroup(), groups.getUnitid());
        if (StringUtils.isNotNull(info))
        {
            return UserConstants.DEPT_NAME_NOT_UNIQUE;
        }
        return UserConstants.DEPT_NAME_UNIQUE;

    }

    /**
     * 新增课题组管理
     * 
     * @param researchGroups 课题组管理
     * @return 结果
     */
    @Override
    public int insertResearchGroups(ResearchGroups researchGroups)
    {
        return researchGroupsMapper.insertResearchGroups(researchGroups);
    }


    /**
     * 修改课题组管理
     * 
     * @param researchGroups 课题组管理
     * @return 结果
     */
    @Override
    public int updateResearchGroups(ResearchGroups researchGroups)
    {
        return researchGroupsMapper.updateResearchGroups(researchGroups);
    }

    /**
     * 删除课题组管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteResearchGroupsByIds(String ids)
    {
        return researchGroupsMapper.deleteResearchGroupsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除课题组管理信息
     * 
     * @param id 课题组管理ID
     * @return 结果
     */
    @Override
    public int deleteResearchGroupsById(Long id)
    {
        return researchGroupsMapper.deleteResearchGroupsById(id);
    }
}
