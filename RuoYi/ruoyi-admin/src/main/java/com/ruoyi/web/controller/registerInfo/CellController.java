package com.ruoyi.web.controller.registerInfo;

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
import com.ruoyi.system.domain.Cell;
import com.ruoyi.system.service.ICellService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * cellController
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Controller
@RequestMapping("/system/cell")
public class CellController extends BaseController
{
    private String prefix = "system/cell";

    @Autowired
    private ICellService cellService;

    @RequiresPermissions("system:cell:view")
    @GetMapping()
    public String cell()
    {
        return prefix + "/cell";
    }

    /**
     * 查询cell列表
     */
    @RequiresPermissions("system:cell:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Cell cell)
    {
        startPage();
        List<Cell> list = cellService.selectCellList(cell);
        return getDataTable(list);
    }

    /**
     * 导出cell列表
     */
    @RequiresPermissions("system:cell:export")
    @Log(title = "cell", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Cell cell)
    {
        List<Cell> list = cellService.selectCellList(cell);
        ExcelUtil<Cell> util = new ExcelUtil<Cell>(Cell.class);
        return util.exportExcel(list, "cell");
    }

    /**
     * 新增cell
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存cell
     */
    @RequiresPermissions("system:cell:add")
    @Log(title = "cell", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Cell cell)
    {
        return toAjax(cellService.insertCell(cell));
    }

    /**
     * 修改cell
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Cell cell = cellService.selectCellById(id);
        mmap.put("cell", cell);
        return prefix + "/edit";
    }

    /**
     * 修改保存cell
     */
    @RequiresPermissions("system:cell:edit")
    @Log(title = "cell", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Cell cell)
    {
        return toAjax(cellService.updateCell(cell));
    }

    /**
     * 删除cell
     */
    @RequiresPermissions("system:cell:remove")
    @Log(title = "cell", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(cellService.deleteCellByIds(ids));
    }
}
