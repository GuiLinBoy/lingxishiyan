package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.NotepadMapper;
import com.ruoyi.system.domain.Notepad;
import com.ruoyi.system.service.INotepadService;
import com.ruoyi.common.core.text.Convert;

/**
 * j记事本Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class NotepadServiceImpl implements INotepadService 
{
    @Autowired
    private NotepadMapper notepadMapper;

    /**
     * 查询j记事本
     * 
     * @param id j记事本ID
     * @return j记事本
     */
    @Override
    public Notepad selectNotepadById(Long id)
    {
        return notepadMapper.selectNotepadById(id);
    }

    /**
     * 查询j记事本列表
     * 
     * @param notepad j记事本
     * @return j记事本
     */
    @Override
    public List<Notepad> selectNotepadList(Notepad notepad)
    {
        return notepadMapper.selectNotepadList(notepad);
    }

    /**
     * 新增j记事本
     * 
     * @param notepad j记事本
     * @return 结果
     */
    @Override
    public int insertNotepad(Notepad notepad)
    {
        return notepadMapper.insertNotepad(notepad);
    }

    /**
     * 修改j记事本
     * 
     * @param notepad j记事本
     * @return 结果
     */
    @Override
    public int updateNotepad(Notepad notepad)
    {
        return notepadMapper.updateNotepad(notepad);
    }

    /**
     * 删除j记事本对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNotepadByIds(String ids)
    {
        return notepadMapper.deleteNotepadByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除j记事本信息
     * 
     * @param id j记事本ID
     * @return 结果
     */
    @Override
    public int deleteNotepadById(Long id)
    {
        return notepadMapper.deleteNotepadById(id);
    }
}
