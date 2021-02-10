package com.ruoyi.system.service;

import com.ruoyi.system.domain.Microbial;

import java.util.List;

/**
 * microbialService接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface IMicrobialService 
{
    /**
     * 查询microbial
     * 
     * @param id microbialID
     * @return microbial
     */
    public Microbial selectMicrobialById(Long id);

    /**
     * 查询microbial列表
     * 
     * @param microbial microbial
     * @return microbial集合
     */
    public List<Microbial> selectMicrobialList(Microbial microbial);

    /**
     * 新增microbial
     * 
     * @param microbial microbial
     * @return 结果
     */
    public int insertMicrobial(Microbial microbial);

    /**
     * 修改microbial
     * 
     * @param microbial microbial
     * @return 结果
     */
    public int updateMicrobial(Microbial microbial);

    /**
     * 批量删除microbial
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMicrobialByIds(String ids);

    /**
     * 删除microbial信息
     * 
     * @param id microbialID
     * @return 结果
     */
    public int deleteMicrobialById(Long id);

    Microbial findMicrobialByOrderId(Long orderId, Long orderIf);
}
