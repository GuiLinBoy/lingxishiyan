package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Notepad;

/**
 * j记事本Service接口
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
public interface INotepadService 
{
    /**
     * 查询j记事本
     * 
     * @param id j记事本ID
     * @return j记事本
     */
    public Notepad selectNotepadById(Long id);

    /**
     * 查询j记事本列表
     * 
     * @param notepad j记事本
     * @return j记事本集合
     */
    public List<Notepad> selectNotepadList(Notepad notepad);

    /**
     * 新增j记事本
     * 
     * @param notepad j记事本
     * @return 结果
     */
    public int insertNotepad(Notepad notepad);

    /**
     * 修改j记事本
     * 
     * @param notepad j记事本
     * @return 结果
     */
    public int updateNotepad(Notepad notepad);

    /**
     * 批量删除j记事本
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNotepadByIds(String ids);

    /**
     * 删除j记事本信息
     * 
     * @param id j记事本ID
     * @return 结果
     */
    public int deleteNotepadById(Long id);
}
