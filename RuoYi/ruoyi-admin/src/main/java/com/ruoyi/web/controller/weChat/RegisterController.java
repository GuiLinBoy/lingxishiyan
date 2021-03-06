package com.ruoyi.web.controller.weChat;

import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.IRegisterInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Classname RegisterController
 * @Author ZhangGY
 * @Date 2021/1/8 15:34
 **/

@RestController
@RequestMapping("/weChat")
public class RegisterController {

    @Autowired
    private IRegisterInfoService registerInfoService;

    /**
     * @Author ZhangGY
     * @Description //TODO 根据用户ID查询表
     * @Date 15:39 2021/1/8
     * @Param [registerUser]
     * @return List<RegisterInfo>
     **/
    @ResponseBody
    @RequestMapping("/findRegisterInfo")
    public List<RegisterInfo> findRegisterInfo(Integer registerUser){return registerInfoService.selectRegisterInfoByUserId(registerUser);}

    /**
     * @Author ZhangGY
     * @Description //TODO 更新保存登记信息
     * @Date 15:54 2021/1/8
     * @Param [registerInfo]
     * @return ：0代表保存失败，1代表保存成功
     **/
    @ResponseBody
    @RequestMapping("/saveAndUpdateRegisterInfo")
    public int saveAndUpdateRegisterInfo(@RequestBody RegisterInfoTool registerInfoTool){
        Integer registerId = null;
        if (registerInfoTool.getRegisterInfo() != null){
            registerId =  registerInfoService.saveAndUpdateRegisterInfo(registerInfoTool);
        };
        return registerId;
    }

    @ResponseBody
    @PostMapping("/findAntiBodyByRegisterId")
    public Antibody findAntiBodyByOrderId(Integer registerId){
        return registerInfoService.findAntiBodyByOrderId(registerId);
    }

    @ResponseBody
    @PostMapping("/findPlasmidByRegisterId")
    public Plasmid findPlasmidByOrderId(Integer registerId){
        return registerInfoService.findPlasmidByOrderId(registerId);
    }

    @ResponseBody
    @PostMapping("/findCellByRegisterId")
    public Cell findCellByOrderId(Integer registerId){
        return registerInfoService.findCellByOrderId(registerId);
    }

    @ResponseBody
    @PostMapping("/findMicrobialByRegisterId")
    public Microbial findMicrobialByOrderId(Integer registerId){
        return registerInfoService.findMicrobialByOrderId(registerId);
    }

    @ResponseBody
    @PostMapping("/findAnimalByRegisterId")
    public Animal findAnimalByOrderId(Integer registerId){
        return registerInfoService.findAnimalByOrderId(registerId);
    }

}
