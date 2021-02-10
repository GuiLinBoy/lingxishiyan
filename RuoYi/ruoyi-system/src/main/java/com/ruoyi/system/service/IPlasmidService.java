package com.ruoyi.system.service;

import com.ruoyi.system.domain.Plasmid;

import java.util.List;

/**
 * plasmidService接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface IPlasmidService 
{
    /**
     * 查询plasmid
     * 
     * @param id plasmidID
     * @return plasmid
     */
    public Plasmid selectPlasmidById(Long id);

    /**
     * 查询plasmid列表
     * 
     * @param plasmid plasmid
     * @return plasmid集合
     */
    public List<Plasmid> selectPlasmidList(Plasmid plasmid);

    /**
     * 新增plasmid
     * 
     * @param plasmid plasmid
     * @return 结果
     */
    public int insertPlasmid(Plasmid plasmid);

    /**
     * 修改plasmid
     * 
     * @param plasmid plasmid
     * @return 结果
     */
    public int updatePlasmid(Plasmid plasmid);

    /**
     * 批量删除plasmid
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlasmidByIds(String ids);

    /**
     * 删除plasmid信息
     * 
     * @param id plasmidID
     * @return 结果
     */
    public int deletePlasmidById(Long id);

    Plasmid findPlasmidByOrderId(Long orderId, Long orderIf);
}
