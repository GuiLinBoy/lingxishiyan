package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Cell;
import com.ruoyi.system.mapper.CellMapper;
import com.ruoyi.system.service.ICellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * cellService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Service
public class CellServiceImpl implements ICellService 
{
    @Autowired
    private CellMapper cellMapper;

    /**
     * 查询cell
     * 
     * @param id cellID
     * @return cell
     */
    @Override
    public Cell selectCellById(Long id)
    {
        return cellMapper.selectCellById(id);
    }

    /**
     * 查询cell列表
     * 
     * @param cell cell
     * @return cell
     */
    @Override
    public List<Cell> selectCellList(Cell cell)
    {
        return cellMapper.selectCellList(cell);
    }

    @Override
    public Cell findCellByOrderId(Long orderId, Long orderIf) {
        return cellMapper.findCellByOrderId(orderId,orderIf);
    }

    /**
     * 新增cell
     * 
     * @param cell cell
     * @return 结果
     */
    @Override
    public int insertCell(Cell cell)
    {
        return cellMapper.insertCell(cell);
    }

    /**
     * 修改cell
     * 
     * @param cell cell
     * @return 结果
     */
    @Override
    public int updateCell(Cell cell)
    {
        return cellMapper.updateCell(cell);
    }

    /**
     * 删除cell对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCellByIds(String ids)
    {
        return cellMapper.deleteCellByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除cell信息
     * 
     * @param id cellID
     * @return 结果
     */
    @Override
    public int deleteCellById(Long id)
    {
        return cellMapper.deleteCellById(id);
    }
}
