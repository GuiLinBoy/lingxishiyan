package com.ruoyi.web.controller.weChat;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Units;
import com.ruoyi.system.service.IUnitsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 单位管理Controller
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/system/units")
public class UnitsController extends BaseController
{
    private String prefix = "system/units";

    @Autowired
    private IUnitsService unitsService;

    @RequiresPermissions("system:units:view")
    @GetMapping()
    public String units()
    {
        return prefix + "/units";
    }

    /**
     * 查询单位管理列表
     */
    @RequiresPermissions("system:units:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Units units)
    {
        startPage();
        List<Units> list = unitsService.selectUnitsList(units);
        return getDataTable(list);
    }

    /**
     * 导出单位管理列表
     */
    @RequiresPermissions("system:units:export")
    @Log(title = "单位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Units units)
    {
        List<Units> list = unitsService.selectUnitsList(units);
        ExcelUtil<Units> util = new ExcelUtil<Units>(Units.class);
        return util.exportExcel(list, "units");
    }

    /**
     * 新增单位管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存单位管理
     */
    @RequiresPermissions("system:units:add")
    @Log(title = "单位管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Units units)
    {
        return toAjax(unitsService.insertUnits(units));
    }

    /**
     * 修改单位管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Units units = unitsService.selectUnitsById(id);
        mmap.put("units", units);
        return prefix + "/edit";
    }

    /**
     * 修改保存单位管理
     */
    @RequiresPermissions("system:units:edit")
    @Log(title = "单位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Units units)
    {
        return toAjax(unitsService.updateUnits(units));
    }

    /**
     * 删除单位管理
     */
    @RequiresPermissions("system:units:remove")
    @Log(title = "单位管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(unitsService.deleteUnitsByIds(ids));
    }
}
