package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Plasmid;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * plasmidMapper接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface PlasmidMapper 
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
     * 删除plasmid
     * 
     * @param id plasmidID
     * @return 结果
     */
    public int deletePlasmidById(Long id);

    /**
     * 批量删除plasmid
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlasmidByIds(String[] ids);

    Plasmid findPlasmidByOrderId(@Param("orderId") Long orderId, @Param("orderIf") Long orderIf);
}
