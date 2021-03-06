package com.ruoyi.web.controller.researchGroups;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.ResearchGroups;
import com.ruoyi.system.service.IResearchGroupsService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 研究组管理Controller
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/system/groups")
public class ResearchGroupsController extends BaseController
{
    private String prefix = "system/groups";

    @Autowired
    private IResearchGroupsService researchGroupsService;

    @RequiresPermissions("system:groups:view")
    @GetMapping()
    public String groups()
    {
        return prefix + "/groups";
    }

    /**
     * 查询研究组管理列表
     */
    @RequiresPermissions("system:groups:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(ResearchGroups researchGroups)
    {
        startPage();
        List<ResearchGroups> list = researchGroupsService.selectResearchGroupsList(researchGroups);
        return getDataTable(list);
    }

    /**
     * 导出研究组管理列表
     */
    @RequiresPermissions("system:groups:export")
    @Log(title = "研究组管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(ResearchGroups researchGroups)
    {
        List<ResearchGroups> list = researchGroupsService.selectResearchGroupsList(researchGroups);
        ExcelUtil<ResearchGroups> util = new ExcelUtil<ResearchGroups>(ResearchGroups.class);
        return util.exportExcel(list, "groups");
    }


    /**
     * 校验单位名称
     */
    @PostMapping("/checkGroupNameUnique")
    @ResponseBody
    public String checkGroupNameUnique(ResearchGroups groups)
    {
        return researchGroupsService.checkGroupNameUnique(groups);
    }

    /**
     * 新增研究组管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存研究组管理
     */
    @RequiresPermissions("system:groups:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(ResearchGroups researchGroups)
    {
        return toAjax(researchGroupsService.insertResearchGroups(researchGroups));
    }


    /**
     * 修改研究组管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        ResearchGroups researchGroups = researchGroupsService.selectResearchGroupsById(id);
        mmap.put("researchGroups", researchGroups);
        return prefix + "/edit";
    }

    /**
     * 修改保存研究组管理
     */
    @RequiresPermissions("system:groups:edit")
    @Log(title = "研究组管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(ResearchGroups researchGroups)
    {
        return toAjax(researchGroupsService.updateResearchGroups(researchGroups));
    }

    /**
     * 删除研究组管理
     */
    @RequiresPermissions("system:groups:remove")
    @Log(title = "研究组管理", businessType = BusinessType.DELETE)
    @GetMapping( "/remove/{deptId}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("deptId") Long deptId) {return toAjax(  researchGroupsService.deleteResearchGroupsByIds(deptId.toString()));}

}
