package com.ruoyi.web.controller.tool;

import com.ruoyi.system.domain.Userinfo;

/**
 * @Classname UserInfoUnTool
 * @Author ZhangGY
 * @Date 2021/1/7 23:57
 **/
public class UserInfoUnTool {

    private Userinfo userinfo;
    private String researchGroupName;

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }

    public String getResearchGroupName() {
        return researchGroupName;
    }

    public void setResearchGroupName(String researchGroupName) {
        this.researchGroupName = researchGroupName;
    }
}
