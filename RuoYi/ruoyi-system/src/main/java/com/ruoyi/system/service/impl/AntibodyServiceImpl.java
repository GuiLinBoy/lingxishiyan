package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Antibody;
import com.ruoyi.system.mapper.AntibodyMapper;
import com.ruoyi.system.service.IAntibodyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * antibodyService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Service
public class AntibodyServiceImpl implements IAntibodyService 
{
    @Autowired
    private AntibodyMapper antibodyMapper;

    /**
     * 查询antibody
     * 
     * @param id antibodyID
     * @return antibody
     */
    @Override
    public Antibody selectAntibodyById(Long id)
    {
        return antibodyMapper.selectAntibodyById(id);
    }

    @Override
    public Antibody findAntiBodyByOrderId(Long orderId,Long orderIf) {
        return antibodyMapper.findAntiBodyByOrderId(orderId,orderIf);
    }

    /**
     * 查询antibody列表
     * 
     * @param antibody antibody
     * @return antibody
     */
    @Override
    public List<Antibody> selectAntibodyList(Antibody antibody)
    {
        return antibodyMapper.selectAntibodyList(antibody);
    }

    /**
     * 新增antibody
     * 
     * @param antibody antibody
     * @return 结果
     */
    @Override
    public int insertAntibody(Antibody antibody)
    {
        return antibodyMapper.insertAntibody(antibody);
    }

    /**
     * 修改antibody
     * 
     * @param antibody antibody
     * @return 结果
     */
    @Override
    public int updateAntibody(Antibody antibody)
    {
        return antibodyMapper.updateAntibody(antibody);
    }

    /**
     * 删除antibody对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAntibodyByIds(String ids)
    {
        return antibodyMapper.deleteAntibodyByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除antibody信息
     * 
     * @param id antibodyID
     * @return 结果
     */
    @Override
    public int deleteAntibodyById(Long id)
    {
        return antibodyMapper.deleteAntibodyById(id);
    }
}
