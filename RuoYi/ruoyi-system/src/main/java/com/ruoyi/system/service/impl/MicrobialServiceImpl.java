package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Microbial;
import com.ruoyi.system.mapper.MicrobialMapper;
import com.ruoyi.system.service.IMicrobialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * microbialService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Service
public class MicrobialServiceImpl implements IMicrobialService 
{
    @Autowired
    private MicrobialMapper microbialMapper;

    /**
     * 查询microbial
     * 
     * @param id microbialID
     * @return microbial
     */
    @Override
    public Microbial selectMicrobialById(Long id)
    {
        return microbialMapper.selectMicrobialById(id);
    }

    /**
     * 查询microbial列表
     * 
     * @param microbial microbial
     * @return microbial
     */
    @Override
    public List<Microbial> selectMicrobialList(Microbial microbial)
    {
        return microbialMapper.selectMicrobialList(microbial);
    }

    @Override
    public Microbial findMicrobialByOrderId(Long orderId, Long orderIf) {
        return microbialMapper.findMicrobialByOrderId(orderId,orderIf);
    }

    /**
     * 新增microbial
     * 
     * @param microbial microbial
     * @return 结果
     */
    @Override
    public int insertMicrobial(Microbial microbial)
    {
        return microbialMapper.insertMicrobial(microbial);
    }

    /**
     * 修改microbial
     * 
     * @param microbial microbial
     * @return 结果
     */
    @Override
    public int updateMicrobial(Microbial microbial)
    {
        return microbialMapper.updateMicrobial(microbial);
    }

    /**
     * 删除microbial对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteMicrobialByIds(String ids)
    {
        return microbialMapper.deleteMicrobialByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除microbial信息
     * 
     * @param id microbialID
     * @return 结果
     */
    @Override
    public int deleteMicrobialById(Long id)
    {
        return microbialMapper.deleteMicrobialById(id);
    }
}
