package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Cell;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * cellMapper接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface CellMapper 
{
    /**
     * 查询cell
     * 
     * @param id cellID
     * @return cell
     */
    public Cell selectCellById(Long id);

    /**
     * 查询cell列表
     * 
     * @param cell cell
     * @return cell集合
     */
    public List<Cell> selectCellList(Cell cell);

    /**
     * 新增cell
     * 
     * @param cell cell
     * @return 结果
     */
    public int insertCell(Cell cell);

    /**
     * 修改cell
     * 
     * @param cell cell
     * @return 结果
     */
    public int updateCell(Cell cell);

    /**
     * 删除cell
     * 
     * @param id cellID
     * @return 结果
     */
    public int deleteCellById(Long id);

    /**
     * 批量删除cell
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCellByIds(String[] ids);

    Cell findCellByOrderId(@Param("orderId") Long orderId, @Param("orderIf") Long orderIf);
}
