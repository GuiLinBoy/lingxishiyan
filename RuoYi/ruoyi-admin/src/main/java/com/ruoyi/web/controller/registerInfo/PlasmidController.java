package com.ruoyi.web.controller.registerInfo;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Plasmid;
import com.ruoyi.system.service.IPlasmidService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * plasmidController
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Controller
@RequestMapping("/system/plasmid")
public class PlasmidController extends BaseController
{
    private String prefix = "system/plasmid";

    @Autowired
    private IPlasmidService plasmidService;

    @RequiresPermissions("system:plasmid:view")
    @GetMapping()
    public String plasmid()
    {
        return prefix + "/plasmid";
    }

    /**
     * 查询plasmid列表
     */
    @RequiresPermissions("system:plasmid:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Plasmid plasmid)
    {
        startPage();
        List<Plasmid> list = plasmidService.selectPlasmidList(plasmid);
        return getDataTable(list);
    }

    /**
     * 导出plasmid列表
     */
    @RequiresPermissions("system:plasmid:export")
    @Log(title = "plasmid", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Plasmid plasmid)
    {
        List<Plasmid> list = plasmidService.selectPlasmidList(plasmid);
        ExcelUtil<Plasmid> util = new ExcelUtil<Plasmid>(Plasmid.class);
        return util.exportExcel(list, "plasmid");
    }

    /**
     * 新增plasmid
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存plasmid
     */
    @RequiresPermissions("system:plasmid:add")
    @Log(title = "plasmid", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Plasmid plasmid)
    {
        return toAjax(plasmidService.insertPlasmid(plasmid));
    }

    /**
     * 修改plasmid
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Plasmid plasmid = plasmidService.selectPlasmidById(id);
        mmap.put("plasmid", plasmid);
        return prefix + "/edit";
    }

    /**
     * 修改保存plasmid
     */
    @RequiresPermissions("system:plasmid:edit")
    @Log(title = "plasmid", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Plasmid plasmid)
    {
        return toAjax(plasmidService.updatePlasmid(plasmid));
    }

    /**
     * 删除plasmid
     */
    @RequiresPermissions("system:plasmid:remove")
    @Log(title = "plasmid", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(plasmidService.deletePlasmidByIds(ids));
    }
}
