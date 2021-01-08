package com.ruoyi.web.controller.weChat;

import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.service.IResearchGroupsService;
import com.ruoyi.system.service.IUserinfoService;
import com.ruoyi.web.controller.tool.UserInfoUnTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname WeChatUserInfoController
 * @Author ZhangGY
 * @Date 2021/1/7 20:10
 **/
@RestController
@RequestMapping("/weChat")
public class WeChatUserInfoController {

    @Autowired
    private IUserinfoService userinfoService;

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
}
