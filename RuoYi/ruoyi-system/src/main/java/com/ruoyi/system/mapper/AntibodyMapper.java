package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Antibody;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * antibodyMapper接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface AntibodyMapper 
{
    /**
     * 查询antibody
     * 
     * @param id antibodyID
     * @return antibody
     */
    public Antibody selectAntibodyById(Long id);

    /**
     * 查询antibody列表
     * 
     * @param antibody antibody
     * @return antibody集合
     */
    public List<Antibody> selectAntibodyList(Antibody antibody);

    /**
     * 新增antibody
     * 
     * @param antibody antibody
     * @return 结果
     */
    public int insertAntibody(Antibody antibody);

    /**
     * 修改antibody
     * 
     * @param antibody antibody
     * @return 结果
     */
    public int updateAntibody(Antibody antibody);

    /**
     * 删除antibody
     * 
     * @param id antibodyID
     * @return 结果
     */
    public int deleteAntibodyById(Long id);

    /**
     * 批量删除antibody
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAntibodyByIds(String[] ids);

    Antibody findAntiBodyByOrderId(@Param("orderId") Long orderId,@Param("orderIf") Long orderIf);
}
