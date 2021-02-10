package com.ruoyi.system.service;

import com.ruoyi.system.domain.OrderPic;

import java.util.List;

/**
 * upload_picService接口
 * 
 * @author ruoyi
 * @date 2021-01-25
 */
public interface IOrderPicService 
{
    /**
     * 查询upload_pic
     * 
     * @param id upload_picID
     * @return upload_pic
     */
    public OrderPic selectOrderPicById(Long id);

    /**
     * 查询upload_pic列表
     * 
     * @param orderPic upload_pic
     * @return upload_pic集合
     */
    public List<OrderPic> selectOrderPicList(OrderPic orderPic);

    /**
     * 新增upload_pic
     * 
     * @param orderPic upload_pic
     * @return 结果
     */
    public int insertOrderPic(OrderPic orderPic);

    /**
     * 修改upload_pic
     * 
     * @param orderPic upload_pic
     * @return 结果
     */
    public int updateOrderPic(OrderPic orderPic);

    /**
     * 批量删除upload_pic
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderPicByIds(String ids);

    /**
     * 删除upload_pic信息
     * 
     * @param id upload_picID
     * @return 结果
     */
    public int deleteOrderPicById(Long id);

    OrderPic findOrderPicByOrderId(Long orderId);
}
