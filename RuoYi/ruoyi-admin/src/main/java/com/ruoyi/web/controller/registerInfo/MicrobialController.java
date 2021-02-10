package com.ruoyi.web.controller.registerInfo;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Microbial;
import com.ruoyi.system.service.IMicrobialService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * microbialController
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Controller
@RequestMapping("/system/microbial")
public class MicrobialController extends BaseController
{
    private String prefix = "system/microbial";

    @Autowired
    private IMicrobialService microbialService;

    @RequiresPermissions("system:microbial:view")
    @GetMapping()
    public String microbial()
    {
        return prefix + "/microbial";
    }

    /**
     * 查询microbial列表
     */
    @RequiresPermissions("system:microbial:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Microbial microbial)
    {
        startPage();
        List<Microbial> list = microbialService.selectMicrobialList(microbial);
        return getDataTable(list);
    }

    /**
     * 导出microbial列表
     */
    @RequiresPermissions("system:microbial:export")
    @Log(title = "microbial", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Microbial microbial)
    {
        List<Microbial> list = microbialService.selectMicrobialList(microbial);
        ExcelUtil<Microbial> util = new ExcelUtil<Microbial>(Microbial.class);
        return util.exportExcel(list, "microbial");
    }

    /**
     * 新增microbial
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存microbial
     */
    @RequiresPermissions("system:microbial:add")
    @Log(title = "microbial", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Microbial microbial)
    {
        return toAjax(microbialService.insertMicrobial(microbial));
    }

    /**
     * 修改microbial
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Microbial microbial = microbialService.selectMicrobialById(id);
        mmap.put("microbial", microbial);
        return prefix + "/edit";
    }

    /**
     * 修改保存microbial
     */
    @RequiresPermissions("system:microbial:edit")
    @Log(title = "microbial", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Microbial microbial)
    {
        return toAjax(microbialService.updateMicrobial(microbial));
    }

    /**
     * 删除microbial
     */
    @RequiresPermissions("system:microbial:remove")
    @Log(title = "microbial", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(microbialService.deleteMicrobialByIds(ids));
    }
}
