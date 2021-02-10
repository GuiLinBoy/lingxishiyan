package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Plasmid;
import com.ruoyi.system.mapper.PlasmidMapper;
import com.ruoyi.system.service.IPlasmidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * plasmidService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Service
public class PlasmidServiceImpl implements IPlasmidService 
{
    @Autowired
    private PlasmidMapper plasmidMapper;

    /**
     * 查询plasmid
     * 
     * @param id plasmidID
     * @return plasmid
     */
    @Override
    public Plasmid selectPlasmidById(Long id)
    {
        return plasmidMapper.selectPlasmidById(id);
    }

    @Override
    public Plasmid findPlasmidByOrderId(Long orderId, Long orderIf) {

        return plasmidMapper.findPlasmidByOrderId(orderId,orderIf);
    }

    /**
     * 查询plasmid列表
     * 
     * @param plasmid plasmid
     * @return plasmid
     */
    @Override
    public List<Plasmid> selectPlasmidList(Plasmid plasmid)
    {
        return plasmidMapper.selectPlasmidList(plasmid);
    }

    /**
     * 新增plasmid
     * 
     * @param plasmid plasmid
     * @return 结果
     */
    @Override
    public int insertPlasmid(Plasmid plasmid)
    {
        return plasmidMapper.insertPlasmid(plasmid);
    }

    /**
     * 修改plasmid
     * 
     * @param plasmid plasmid
     * @return 结果
     */
    @Override
    public int updatePlasmid(Plasmid plasmid)
    {
        return plasmidMapper.updatePlasmid(plasmid);
    }

    /**
     * 删除plasmid对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePlasmidByIds(String ids)
    {
        return plasmidMapper.deletePlasmidByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除plasmid信息
     * 
     * @param id plasmidID
     * @return 结果
     */
    @Override
    public int deletePlasmidById(Long id)
    {
        return plasmidMapper.deletePlasmidById(id);
    }
}
