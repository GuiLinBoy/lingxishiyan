package com.ruoyi.system.service;

import com.ruoyi.system.domain.Notepad;

import java.util.List;

/**
 * 记事本Service接口
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
public interface INotepadService 
{
    /**
     * 查询记事本
     * 
     * @param id 记事本ID
     * @return 记事本
     */
    public Notepad selectNotepadById(Long id);

    /**
     * 查询记事本列表
     * 
     * @param notepad 记事本
     * @return 记事本集合
     */
    public List<Notepad> selectNotepadList(Notepad notepad);

    /**
     * 新增记事本
     * 
     * @param notepad 记事本
     * @return 结果
     */
    public int insertNotepad(Notepad notepad);

    /**
     * 修改记事本
     * 
     * @param notepad 记事本
     * @return 结果
     */
    public int updateNotepad(Notepad notepad);

    /**
     * 批量删除记事本
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNotepadByIds(String ids);

    /**
     * 删除记事本信息
     * 
     * @param id 记事本ID
     * @return 结果
     */
    public int deleteNotepadById(Long id);

    List<Notepad> findNotePadByUserId(Integer userId);

    int saveAndUpdateNotePad(Notepad notepad);
}
