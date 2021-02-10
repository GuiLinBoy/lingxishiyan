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
import com.ruoyi.system.domain.Antibody;
import com.ruoyi.system.service.IAntibodyService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * antibodyController
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Controller
@RequestMapping("/system/抗体")
public class AntibodyController extends BaseController
{
    private String prefix = "system/抗体";

    @Autowired
    private IAntibodyService antibodyService;

    @RequiresPermissions("system:抗体:view")
    @GetMapping()
    public String 抗体()
    {
        return prefix + "/抗体";
    }

    /**
     * 查询antibody列表
     */
    @RequiresPermissions("system:抗体:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Antibody antibody)
    {
        startPage();
        List<Antibody> list = antibodyService.selectAntibodyList(antibody);
        return getDataTable(list);
    }

    /**
     * 导出antibody列表
     */
    @RequiresPermissions("system:抗体:export")
    @Log(title = "antibody", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Antibody antibody)
    {
        List<Antibody> list = antibodyService.selectAntibodyList(antibody);
        ExcelUtil<Antibody> util = new ExcelUtil<Antibody>(Antibody.class);
        return util.exportExcel(list, "抗体");
    }

    /**
     * 新增antibody
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存antibody
     */
    @RequiresPermissions("system:抗体:add")
    @Log(title = "antibody", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Antibody antibody)
    {
        return toAjax(antibodyService.insertAntibody(antibody));
    }

    /**
     * 修改antibody
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Antibody antibody = antibodyService.selectAntibodyById(id);
        mmap.put("antibody", antibody);
        return prefix + "/edit";
    }

    /**
     * 修改保存antibody
     */
    @RequiresPermissions("system:抗体:edit")
    @Log(title = "antibody", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Antibody antibody)
    {
        return toAjax(antibodyService.updateAntibody(antibody));
    }

    /**
     * 删除antibody
     */
    @RequiresPermissions("system:抗体:remove")
    @Log(title = "antibody", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(antibodyService.deleteAntibodyByIds(ids));
    }
}
