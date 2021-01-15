package com.ruoyi.web.controller.userInfo;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Units;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.service.IUnitsService;
import com.ruoyi.system.service.IUserinfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 人员管理Controller
 * 
 * @author ruoyi
 * @date 2021-01-07
 */
@Controller
@RequestMapping("/system/userinfo")
public class UserinfoController extends BaseController
{
    private String prefix = "system/userinfo";

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private IUnitsService unitsService;

    @RequiresPermissions("system:userinfo:view")
    @GetMapping()
    public String userinfo()
    {
        return prefix + "/userinfo";
    }


    /**
     * 查询人员管理列表
     */
    @RequiresPermissions("system:userinfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Userinfo userinfo)
    {
        startPage();
        List<Userinfo> list = userinfoService.selectUserinfoListTo(userinfo);
        return getDataTable(list);
    }

    /**
     * @Author ZhangGY
     * @Description //TODO 根据用户真实姓名模糊查询
     * @Date 13:30 2021/1/11
     * @Param
     * @return
     **/
    @ResponseBody
    @RequestMapping("/findListLikeByRealName")
    public List<Userinfo> findListLikeByRealName(String realName){
        if (realName != null){
            return userinfoService.selectListLikeByRealName(realName);
        }else return null;
    }
    /**
     * 导出人员管理列表
     */
    @RequiresPermissions("system:userinfo:export")
    @Log(title = "人员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Userinfo userinfo)
    {
        List<Userinfo> list = userinfoService.selectUserinfoList(userinfo);
        ExcelUtil<Userinfo> util = new ExcelUtil<Userinfo>(Userinfo.class);
        return util.exportExcel(list, "userinfo");
    }

    /**
     * 新增人员管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * @Author ZhangGY
     * @Description //TODO 查询单位
     **/

    @ResponseBody
    @RequestMapping("/findUnit")
    public List<Units> findUnit(String unitName){
        return  unitsService.findUnitsLike(unitName);
    }
    /**
     * 新增保存人员管理
     */
    @RequiresPermissions("system:userinfo:add")
    @Log(title = "人员管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Userinfo userinfo)
    {
        return toAjax(userinfoService.insertUserinfo(userinfo));
    }

    /**
     * 修改人员管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Userinfo userinfo = userinfoService.selectUserinfoById(id);
        mmap.put("userinfo", userinfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存人员管理
     */
    @RequiresPermissions("system:userinfo:edit")
    @Log(title = "人员管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Userinfo userinfo)
    {
        return toAjax(userinfoService.updateUserinfo(userinfo));
    }

    /**
     * 删除人员管理
     */
    @RequiresPermissions("system:userinfo:remove")
    @Log(title = "人员管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
//        return toAjax(userinfoService.deleteUserinfoByIds(ids));
        return error("禁止删除用户");
    }
}
