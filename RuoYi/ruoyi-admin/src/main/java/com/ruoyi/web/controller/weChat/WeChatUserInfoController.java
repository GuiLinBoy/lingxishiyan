package com.ruoyi.web.controller.weChat;

import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.service.IResearchGroupsService;
import com.ruoyi.system.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Classname WeChatUserInfoController
 * @Author ZhangGY
 * @Date 2021/1/7 20:10
 **/
@Controller
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
    public int insetUserInfo(Userinfo userinfo, String researchGroupName){

        if (userinfo != null && !researchGroupName.equals("")){
            Long unitId = researchGroupsService.findAndSaveByName(researchGroupName,userinfo.getUnitid());
            userinfo.setUnitid(unitId);
            return userinfoService.insertAndUpdateUserInfo(userinfo);
        }else if (researchGroupName == null)
            return 0;
        else
            return -1;
    }
}
