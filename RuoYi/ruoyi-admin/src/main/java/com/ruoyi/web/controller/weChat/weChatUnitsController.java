package com.ruoyi.web.controller.weChat;

import com.ruoyi.system.domain.Units;
import com.ruoyi.system.service.IUnitsService;
import com.ruoyi.system.service.impl.UnitsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.net.idn.Punycode;

import java.util.List;

/**
 * @Classname weChatUnitsController
 * @Author ZhangGY
 * @Date 2021/1/7 22:40
 **/
@Controller
@RequestMapping("/weChat")
public class weChatUnitsController {


    @Autowired
    private IUnitsService unitsService;


    @ResponseBody
    @RequestMapping("/findUnitsById")
    public Units findUnitsById(Integer unitsId){
        return unitsService.findUnitsById(unitsId);
    }

    @ResponseBody
    @RequestMapping("/findUnitsLike")
    public List<Units> findUnitsLike(String unitName){ return unitsService.findUnitsLike(unitName);
    }

}
