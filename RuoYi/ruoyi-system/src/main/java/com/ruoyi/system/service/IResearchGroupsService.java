package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.ResearchGroups;

/**
 * 研究组管理Service接口
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
public interface IResearchGroupsService 
{
    /**
     * 查询研究组管理
     * 
     * @param id 研究组管理ID
     * @return 研究组管理
     */
    public ResearchGroups selectResearchGroupsById(Long id);

    /**
     * 查询研究组管理列表
     * 
     * @param researchGroups 研究组管理
     * @return 研究组管理集合
     */
    public List<ResearchGroups> selectResearchGroupsList(ResearchGroups researchGroups);

    /**
     * 新增研究组管理
     * 
     * @param researchGroups 研究组管理
     * @return 结果
     */
    public int insertResearchGroups(ResearchGroups researchGroups);

    /**
     * 修改研究组管理
     * 
     * @param researchGroups 研究组管理
     * @return 结果
     */
    public int updateResearchGroups(ResearchGroups researchGroups);

    /**
     * 批量删除研究组管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteResearchGroupsByIds(String ids);

    /**
     * 删除研究组管理信息
     * 
     * @param id 研究组管理ID
     * @return 结果
     */
    public int deleteResearchGroupsById(Long id);

    public Long findAndSaveByName(String researchGroupName, Long  unitid);

    public ResearchGroups findByName(String researchGroupName);

    ResearchGroups findById(Integer groupId);
}
