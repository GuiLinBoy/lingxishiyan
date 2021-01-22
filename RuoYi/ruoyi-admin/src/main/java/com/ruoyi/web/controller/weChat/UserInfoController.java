package com.ruoyi.web.controller.weChat;

import com.ruoyi.system.domain.RegisterInfo;
import com.ruoyi.system.domain.ResearchGroups;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.service.IRegisterInfoService;
import com.ruoyi.system.service.IResearchGroupsService;
import com.ruoyi.system.service.IUserinfoService;
import com.ruoyi.web.controller.tool.UserInfoUnTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname UserInfoController
 * @Author ZhangGY
 * @Date 2021/1/7 20:10
 **/
@RestController
@RequestMapping("/weChat")
public class UserInfoController {

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private IRegisterInfoService registerInfoService;

    @Autowired
    private IResearchGroupsService researchGroupsService;
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
     * @Author ZhangGY
     * @Description //TODO 插入用户信息
     * @Date 20:45 2021/1/7
     * @Param userInfo
     * @return -1：userinfo 为空 ；0：researchGroupName为空
     **/
    @PostMapping("/insetUserInfo")
    @ResponseBody
    public int insetUserInfo(@RequestBody UserInfoUnTool userInfoUnTool){
        Userinfo userinfo = userInfoUnTool.getUserinfo();
        String researchGroupName = userInfoUnTool.getResearchGroupName();
        if (userinfo != null && !researchGroupName.equals("")){
            Long researchGroupId = researchGroupsService.findAndSaveByName(researchGroupName,userinfo.getUnitid());
            userinfo.setResearchGroupId(researchGroupId);
            return userinfoService.insertAndUpdateUserInfo(userinfo);
        }else if (researchGroupName == null)
            return 0;
        else
            return -1;
    }


    /**
     * @Author ZhangGY
     * @Description //TODO 根据单位和课题组查询教授和老师
     * @Date 16:22 2021/1/8
     * @Param [unitid, researchGroupId]
     * @return List<Userinfo>
     **/
    @ResponseBody
    @RequestMapping("/findUserByGroupIdAunitid")
    public List<Userinfo> findUserByGroupIdAunitid(Integer unitid, Integer researchGroupId){
        if (unitid != null && researchGroupId != null){
            return userinfoService.findUserByGroupIdAunitid(unitid,researchGroupId);
        }else
            return null;
    }

    /**
     * @Author ZhangGY
     * @Description //TODO 根据groupId查询对象
     * @Date 16:55 2021/1/9
     * @Param groupID
     * @return
     **/
    @ResponseBody
    @RequestMapping("/findGroupById")
    public ResearchGroups findGroupById(Integer groupId){
        return researchGroupsService.findById(groupId);
    }

    /**
     * @Author ZhangGY
     * @Description //TODO 查询课题组所有成员的登记信息（老师有权限）（排序）
     * @Date 21:32 2021/1/9
     * @Param [groupId]
     * @return  List<RegisterInfo>
     **/
    @ResponseBody
    @RequestMapping("/findRegisterGroupAll")
    public List<RegisterInfo> findRegisterGroupAll(Integer unitid, Integer groupId){
        List<Userinfo> userinfoList = userinfoService.findUserByGroupIdAunitid(unitid, groupId);
        return registerInfoService.selectRegisterByUserId(userinfoList);
    }

    @ResponseBody
    @RequestMapping("/findUserInfoById")
    public Userinfo findUserInfoById(Integer id){
        if (id != null) {
            return userinfoService.selectUserinfoById(id.longValue());
        }else return null;
    }
}
