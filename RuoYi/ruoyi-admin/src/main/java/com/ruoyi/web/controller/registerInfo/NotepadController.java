package com.ruoyi.web.controller.registerInfo;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Notepad;
import com.ruoyi.system.service.INotepadService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 记事本Controller
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
@Controller
@RequestMapping("/system/notepad")
public class NotepadController extends BaseController
{
    private String prefix = "system/notepad";

    @Autowired
    private INotepadService notepadService;

    @RequiresPermissions("system:notepad:view")
    @GetMapping()
    public String notepad()
    {
        return prefix + "/notepad";
    }

    /**
     * 查询记事本列表
     */
    @RequiresPermissions("system:notepad:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Notepad notepad)
    {
        startPage();
        List<Notepad> list = notepadService.selectNotepadList(notepad);
        return getDataTable(list);
    }

    /**
     * 导出记事本列表
     */
    @RequiresPermissions("system:notepad:export")
    @Log(title = "记事本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Notepad notepad)
    {
        List<Notepad> list = notepadService.selectNotepadList(notepad);
        ExcelUtil<Notepad> util = new ExcelUtil<Notepad>(Notepad.class);
        return util.exportExcel(list, "notepad");
    }

    /**
     * 修改记事本
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Notepad notepad = notepadService.selectNotepadById(id);
        mmap.put("notepad", notepad);
        return prefix + "/edit";
    }

    /**
     * 修改保存记事本
     */
    @RequiresPermissions("system:notepad:edit")
    @Log(title = "记事本", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Notepad notepad)
    {
        return toAjax(notepadService.updateNotepad(notepad));
    }

    /**
     * 删除记事本
     */
    @RequiresPermissions("system:notepad:remove")
    @Log(title = "记事本", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(notepadService.deleteNotepadByIds(ids));
    }
}
