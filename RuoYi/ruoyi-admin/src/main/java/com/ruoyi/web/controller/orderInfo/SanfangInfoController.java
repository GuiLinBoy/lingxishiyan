package com.ruoyi.web.controller.orderInfo;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SanfangInfo;
import com.ruoyi.system.service.ISanfangInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * sanFangInfoController
 * 
 * @author ruoyi
 * @date 2021-01-13
 */
@Controller
@RequestMapping("/system/sanFangInfo")
public class SanfangInfoController extends BaseController
{
    private String prefix = "system/sanFangInfo";

    @Autowired
    private ISanfangInfoService sanfangInfoService;

    @RequiresPermissions("system:sanFangInfo:view")
    @GetMapping()
    public String sanFangInfo()
    {
        return prefix + "/sanFangInfo";
    }

    /**
     * 查询sanFangInfo列表
     */
    @RequiresPermissions("system:sanFangInfo:list")
    @RequestMapping("/list/{id}")
    @ResponseBody
    public TableDataInfo list(@PathVariable("id") Integer id)
    {
        startPage();
        List<SanfangInfo> list = sanfangInfoService.selectSanfangInfoByOrderId(id.longValue());
        return getDataTable(list);
    }

    /**
     * 导出sanFangInfo列表
     */
    @RequiresPermissions("system:sanFangInfo:export")
    @Log(title = "sanFangInfo", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SanfangInfo sanfangInfo)
    {
        List<SanfangInfo> list = sanfangInfoService.selectSanfangInfoList(sanfangInfo);
        ExcelUtil<SanfangInfo> util = new ExcelUtil<SanfangInfo>(SanfangInfo.class);
        return util.exportExcel(list, "sanFangInfo");
    }

    /**
     * 新增sanFangInfo
     */
    @RequestMapping("/add/{id}")
    public String add(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("orderId", id);
        return prefix + "/add";
    }

    /**
     * 新增保存sanFangInfo
     */
    @RequiresPermissions("system:sanFangInfo:add")
    @Log(title = "sanFangInfo", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SanfangInfo sanfangInfo)
    {
        return toAjax(sanfangInfoService.insertSanfangInfo(sanfangInfo));
    }

    /**
     * 查看三方
     */
    @GetMapping("/sanFang/{id}")
    public String sanFang(@PathVariable("id") Integer id, ModelMap mmap)
    {
        mmap.put("orderId", id);
        return prefix + "/sanFangInfo";
    }

    /**
     * 修改sanFangInfo
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        SanfangInfo sanfangInfo = sanfangInfoService.selectSanfangInfoById(id);
        mmap.put("sanfangInfo", sanfangInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存sanFangInfo
     */
    @RequiresPermissions("system:sanFangInfo:edit")
    @Log(title = "sanFangInfo", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SanfangInfo sanfangInfo)
    {
        return toAjax(sanfangInfoService.updateSanfangInfo(sanfangInfo));
    }

    /**
     * 删除sanFangInfo
     */
    @RequiresPermissions("system:sanFangInfo:remove")
    @Log(title = "sanFangInfo", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sanfangInfoService.deleteSanfangInfoByIds(ids));
    }
}
