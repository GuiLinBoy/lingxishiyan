package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Notepad;
import com.ruoyi.system.mapper.NotepadMapper;
import com.ruoyi.system.service.INotepadService;
import com.ruoyi.system.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 记事本Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
@Service
public class NotepadServiceImpl implements INotepadService 
{
    @Autowired
    private NotepadMapper notepadMapper;

    @Autowired
    private IUserinfoService userinfoService;
    /**
     * 查询记事本
     * 
     * @param id 记事本ID
     * @return 记事本
     */
    @Override
    public Notepad selectNotepadById(Long id)
    {
        Notepad notepad = notepadMapper.selectNotepadById(id);
        String realName = userinfoService.selectUserinfoById(notepad.getUserid()).getRealname();
        notepad.setUserName(realName);
        return notepad;

    }

    /**
     * 查询记事本列表
     * 
     * @param notepad 记事本
     * @return 记事本
     */
    @Override
    public List<Notepad> selectNotepadList(Notepad notepad)
    {
        List<Notepad> notepadList = notepadMapper.selectNotepadList(notepad);
        for (Notepad notepadTem:notepadList){
            String realName = userinfoService.selectUserinfoById(notepadTem.getUserid()).getRealname();
            notepadTem.setUserName(realName);
        }
        return notepadList;
    }

    /**
     * 新增记事本
     * 
     * @param notepad 记事本
     * @return 结果
     */
    @Override
    public int insertNotepad(Notepad notepad)
    {
        return notepadMapper.insertNotepad(notepad);
    }

    /**
     * 修改记事本
     * 
     * @param notepad 记事本
     * @return 结果
     */
    @Override
    public int updateNotepad(Notepad notepad)
    {
        return notepadMapper.updateNotepad(notepad);
    }

    /**
     * 删除记事本对象
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
     * 删除记事本信息
     * 
     * @param id 记事本ID
     * @return 结果
     */
    @Override
    public int deleteNotepadById(Long id)
    {
        return notepadMapper.deleteNotepadById(id);
    }


    @Override
    public List<Notepad> findNotePadByUserId(Integer userId) {
        return notepadMapper.findNotePadByUserId(userId);
    }

    @Override
    public int saveAndUpdateNotePad(Notepad notepad) {
        if (notepad.getId() != null) {
            return notepadMapper.updateNotepad(notepad);
        }else {
            return notepadMapper.insertNotepad(notepad);
        }
    }
}
