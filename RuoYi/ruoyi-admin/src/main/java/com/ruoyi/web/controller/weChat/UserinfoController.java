package com.ruoyi.web.controller.weChat;

import java.util.List;

import org.apache.catalina.User;
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
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.service.IUserinfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.jws.soap.SOAPBinding;

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

    @RequiresPermissions("system:userinfo:view")
    @GetMapping()
    public String userinfo()
    {
        return prefix + "/userinfo";
    }


    /**
     * @Author ZhangGY
     * @Description //TODO 根据openID查询人员列表
     * @Date 18:01 2021/1/7
     * @Param openID
     * @return
     **/
    @PostMapping("/findUserListByOpenId")
    @ResponseBody
    public Userinfo findUserListByOpenId(String openId){
        if (openId != null){
            Userinfo list = userinfoService.selectUserinfoByOpenId(openId);
            return list;
        }
        return null;
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
        List<Userinfo> list = userinfoService.selectUserinfoList(userinfo);
        return getDataTable(list);
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
        return toAjax(userinfoService.deleteUserinfoByIds(ids));
    }
}
