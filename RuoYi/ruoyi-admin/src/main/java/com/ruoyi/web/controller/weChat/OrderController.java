package com.ruoyi.web.controller.weChat;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.IOrderInfoService;
import com.ruoyi.system.service.IOrderPicService;
import com.ruoyi.system.service.ISanfangInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Classname OrderController
 * @Author ZhangGY
 * @Date 2021/1/13 15:45
 **/
@RestController
@RequestMapping("/weChat")
public class OrderController {

    @Autowired
    private IOrderInfoService orderService;

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private ISanfangInfoService sanfangInfoService;


    @Autowired
    private IOrderPicService orderPicService;

    @ResponseBody
    @RequestMapping("/findOrderByCheckUser")
    public  OrderAndSanFang findOrderByCheckUser(Integer checkUserId){
         return orderService.selectOrderInfoByCheckUserId(checkUserId);
    }

    /**
     * @Author ZhangGY
     * @Description //TODO 查询审核人需要审核的用户姓名
     * @Date 20:55 2021/1/25
     * @Param [checkUserId]
     * @return java.util.List<java.lang.String>
     **/
    @ResponseBody
    @RequestMapping("/findUserByCheckUser")
    public List<Userinfo> findUserByCheckUser(Integer checkUserId,Integer checkState){
        if (checkUserId != null) {
            List<Userinfo> userList = orderService.findUserByCheckUser(checkUserId,checkState);
            return userList;
        }else {
            return null;
        }
    }


    /*
     * @Author ZhangGY
     * @Description //TODO 查询审核人需要审核的订购数目
     * @Date 15:45 2021/2/4
     * @Param
     * @return
     **/
    @ResponseBody
    @RequestMapping("/findOrderCount")
    public int findOrderCount(Integer checkUserId){
        if (checkUserId != null) {
            return orderService.findOrderCount(checkUserId);
        }else {
            return -1;
        }
    }

    @ResponseBody
    @RequestMapping("/selectOrderInfoByOrderUser")
    public OrderAndSanFang selectOrderInfoByOrderUser(Integer OrderUserId,Integer checkState){
        return orderService.selectOrderInfoByOrderUserId(OrderUserId,checkState);
    }

    @ResponseBody
    @RequestMapping("/selectOrderInfoByOrderUserAndCheck")
    public OrderAndSanFang selectOrderInfoByOrderUser(Integer OrderUserId,Integer checkUserId,Integer checkState){
        return orderService.selectOrderInfoByOrderUserId(OrderUserId,checkUserId,checkState);
    }

    /**
     * @Author ZhangGY
     * @Description //TODO 保存订单和三方信息，一张订单可能有多张三方信息
     * @Date 15:59 2021/1/13
     * @Param [orderAndSanFang]
     * @return
     **/
    @ResponseBody
    @RequestMapping("/saveAndUpdateOrder")
    public int saveAndUpdateOrder(@RequestBody OrderAndSanFang orderAndSanFang){
        if (orderAndSanFang != null) {
            return orderService.saveAndUpdateOrder(orderAndSanFang);
        }else return -1;
    }


    @ResponseBody
    @RequestMapping("/findSanFangByOrderId")
    public List<SanfangInfo> findSanFangByOrderId(Integer OrderId){
        if (OrderId != null) {
            return sanfangInfoService.selectSanfangInfoByOrderId(OrderId.longValue());
        }else return null;
    }

    @ResponseBody
    @RequestMapping("/updateCheckState")
    public int updateCheckState(Integer id ,Integer checkState){
        if (id != null && checkState != null){
            return orderService.updateCheckState(id,checkState);
        }else return -1;
    }


    /*
     * @Author ZhangGY
     * @Description //TODO 图片上传
     * @Date 16:00 2021/1/25
     * @Param
     * @return
     **/
    /**
     * 通用上传请求
     */
        @PostMapping("/upload")
        @ResponseBody
        public AjaxResult uploadFile(MultipartFile file) throws Exception
        {
            try
            {
                // 上传文件路径
                String filePath = RuoYiConfig.getUploadPath();
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                AjaxResult ajax = AjaxResult.success();
                ajax.put("fileName", fileName);
                ajax.put("url", url);
                return ajax;
            }
            catch (Exception e)
            {
                return AjaxResult.error(e.getMessage());
            }
        }

        @ResponseBody
        @PostMapping("/findAntiBodyByOrderId")
        public Antibody findAntiBodyByOrderId(Integer orderId){
            return orderService.findAntiBodyByOrderId(orderId);
        }

    @ResponseBody
    @PostMapping("/findPlasmidByOrderId")
    public Plasmid findPlasmidByOrderId(Integer orderId){
        return orderService.findPlasmidByOrderId(orderId);
    }

    @ResponseBody
    @PostMapping("/findCellByOrderId")
    public Cell findCellByOrderId(Integer orderId){
        return orderService.findCellByOrderId(orderId);
    }

    @ResponseBody
    @PostMapping("/findMicrobialByOrderId")
    public Microbial findMicrobialByOrderId(Integer orderId){
        return orderService.findMicrobialByOrderId(orderId);
    }

    @ResponseBody
    @PostMapping("/findAnimalByOrderId")
    public Animal findAnimalByOrderId(Integer orderId){
        return orderService.findAnimalByOrderId(orderId);
    }


    @ResponseBody
    @PostMapping("/findOrderPicByOrderId")
    public OrderPic findOrderPicByOrderId(Integer orderId){
            return orderService.findOrderPicByOrderId(orderId);
    }

}
