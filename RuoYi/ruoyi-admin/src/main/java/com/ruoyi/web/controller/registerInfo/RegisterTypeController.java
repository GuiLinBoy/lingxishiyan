package com.ruoyi.web.controller.registerInfo;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.RegisterType;
import com.ruoyi.system.service.IRegisterTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 登记类型Controller
 * 
 * @author ruoyi
 * @date 2021-01-11
 */
@Controller
@RequestMapping("/system/type")
public class RegisterTypeController extends BaseController
{
    private String prefix = "system/type";

    @Autowired
    private IRegisterTypeService registerTypeService;

    @RequiresPermissions("system:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询登记类型列表
     */
    @RequiresPermissions("system:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RegisterType registerType)
    {
        startPage();
        List<RegisterType> list = registerTypeService.selectRegisterTypeList(registerType);
        return getDataTable(list);
    }

    /**
     * 导出登记类型列表
     */
    @RequiresPermissions("system:type:export")
    @Log(title = "登记类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RegisterType registerType)
    {
        List<RegisterType> list = registerTypeService.selectRegisterTypeList(registerType);
        ExcelUtil<RegisterType> util = new ExcelUtil<RegisterType>(RegisterType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增登记类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存登记类型
     */
    @RequiresPermissions("system:type:add")
    @Log(title = "登记类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RegisterType registerType)
    {
        return toAjax(registerTypeService.insertRegisterType(registerType));
    }

    /**
     * 修改登记类型
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        RegisterType registerType = registerTypeService.selectRegisterTypeById(id);
        mmap.put("registerType", registerType);
        return prefix + "/edit";
    }

    /**
     * 修改保存登记类型
     */
    @RequiresPermissions("system:type:edit")
    @Log(title = "登记类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RegisterType registerType)
    {
        return toAjax(registerTypeService.updateRegisterType(registerType));
    }

    /**
     * 删除登记类型
     */
    @RequiresPermissions("system:type:remove")
    @Log(title = "登记类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(registerTypeService.deleteRegisterTypeByIds(ids));
    }
}
