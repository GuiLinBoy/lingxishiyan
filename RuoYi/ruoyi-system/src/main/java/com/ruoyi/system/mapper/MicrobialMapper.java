package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Microbial;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * microbialMapper接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface MicrobialMapper 
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
     * 删除microbial
     * 
     * @param id microbialID
     * @return 结果
     */
    public int deleteMicrobialById(Long id);

    /**
     * 批量删除microbial
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMicrobialByIds(String[] ids);

    Microbial findMicrobialByOrderId(@Param("orderId") Long orderId, @Param("orderIf") Long orderIf);
}
