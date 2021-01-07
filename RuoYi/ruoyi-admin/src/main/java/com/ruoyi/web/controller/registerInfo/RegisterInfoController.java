package com.ruoyi.web.controller.registerInfo;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.RegisterInfo;
import com.ruoyi.system.service.IRegisterInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 登记信息Controller
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Controller
@RequestMapping("/system/info")
public class RegisterInfoController extends BaseController
{
    private String prefix = "system/info";

    @Autowired
    private IRegisterInfoService registerInfoService;

    @RequiresPermissions("system:info:view")
    @GetMapping()
    public String info()
    {
        return prefix + "/info";
    }

    /**
     * 查询登记信息列表
     */
    @RequiresPermissions("system:info:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RegisterInfo registerInfo)
    {
        startPage();
        List<RegisterInfo> list = registerInfoService.selectRegisterInfoList(registerInfo);
        return getDataTable(list);
    }

    /**
     * 导出登记信息列表
     */
    @RequiresPermissions("system:info:export")
    @Log(title = "登记信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RegisterInfo registerInfo)
    {
        List<RegisterInfo> list = registerInfoService.selectRegisterInfoList(registerInfo);
        ExcelUtil<RegisterInfo> util = new ExcelUtil<RegisterInfo>(RegisterInfo.class);
        return util.exportExcel(list, "info");
    }

    /**
     * 新增登记信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存登记信息
     */
    @RequiresPermissions("system:info:add")
    @Log(title = "登记信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RegisterInfo registerInfo)
    {
        return toAjax(registerInfoService.insertRegisterInfo(registerInfo));
    }

    /**
     * 修改登记信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RegisterInfo registerInfo = registerInfoService.selectRegisterInfoById(id);
        mmap.put("registerInfo", registerInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存登记信息
     */
    @RequiresPermissions("system:info:edit")
    @Log(title = "登记信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RegisterInfo registerInfo)
    {
        return toAjax(registerInfoService.updateRegisterInfo(registerInfo));
    }

    /**
     * 删除登记信息
     */
    @RequiresPermissions("system:info:remove")
    @Log(title = "登记信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(registerInfoService.deleteRegisterInfoByIds(ids));
    }
}
