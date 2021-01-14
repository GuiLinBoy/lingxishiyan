package com.ruoyi.web.controller.weChat;

import com.ruoyi.system.domain.Times;
import com.ruoyi.system.service.ITimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname TimeController
 * @Author ZhangGY
 * @Date 2021/1/14 21:12
 **/
@RestController
@RequestMapping("/weChat")
public class TimeController {


    @Autowired
    private ITimesService timesService;

    @ResponseBody
    @RequestMapping("/findByUserId")
    public Times findByUserId(Integer userId){
        if (userId != null) {
            return timesService.selectTimesByUserId(userId);
        }else return null;
    }

    @ResponseBody
    @RequestMapping("/saveAndUpdateTimes")
    public int saveAndUpdateTimes(Times times){
        return timesService.saveAndUpdateTimes(times);
    }
}
