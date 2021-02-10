package com.ruoyi.system.service;

import com.ruoyi.system.domain.Cell;

import java.util.List;

/**
 * cellService接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface ICellService 
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
     * 批量删除cell
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCellByIds(String ids);

    /**
     * 删除cell信息
     * 
     * @param id cellID
     * @return 结果
     */
    public int deleteCellById(Long id);

    Cell findCellByOrderId(Long orderId, Long orderIf);
}
