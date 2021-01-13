package com.ruoyi.web.controller.orderInfo;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.OrderInfo;
import com.ruoyi.system.service.IOrderInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * orderInfoController
 * 
 * @author ruoyi
 * @date 2021-01-13
 */
@Controller
@RequestMapping("/system/orderInfo")
public class OrderInfoController extends BaseController
{
    private String prefix = "system/orderInfo";

    @Autowired
    private IOrderInfoService orderInfoService;

    @RequiresPermissions("system:orderInfo:view")
    @GetMapping()
    public String orderInfo()
    {
        return prefix + "/orderInfo";
    }

    /**
     * 查询orderInfo列表
     */
    @RequiresPermissions("system:orderInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(OrderInfo orderInfo)
    {
        startPage();
        List<OrderInfo> list = orderInfoService.selectOrderInfoList(orderInfo);
        return getDataTable(list);
    }

    /**
     * 导出orderInfo列表
     */
    @RequiresPermissions("system:orderInfo:export")
    @Log(title = "orderInfo", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(OrderInfo orderInfo)
    {
        List<OrderInfo> list = orderInfoService.selectOrderInfoList(orderInfo);
        ExcelUtil<OrderInfo> util = new ExcelUtil<OrderInfo>(OrderInfo.class);
        return util.exportExcel(list, "orderInfo");
    }

    /**
     * 新增orderInfo
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存orderInfo
     */
    @RequiresPermissions("system:orderInfo:add")
    @Log(title = "orderInfo", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(OrderInfo orderInfo)
    {
        return toAjax(orderInfoService.insertOrderInfo(orderInfo));
    }

    /**
     * 修改orderInfo
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        OrderInfo orderInfo = orderInfoService.selectOrderInfoById(id);
        mmap.put("orderInfo", orderInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存orderInfo
     */
    @RequiresPermissions("system:orderInfo:edit")
    @Log(title = "orderInfo", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(OrderInfo orderInfo)
    {
        return toAjax(orderInfoService.updateOrderInfo(orderInfo));
    }

    /**
     * 删除orderInfo
     */
    @RequiresPermissions("system:orderInfo:remove")
    @Log(title = "orderInfo", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(orderInfoService.deleteOrderInfoByIds(ids));
    }
}
