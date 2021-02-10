package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.OrderPic;
import com.ruoyi.system.mapper.OrderPicMapper;
import com.ruoyi.system.service.IOrderPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * upload_picService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-25
 */
@Service
public class OrderPicServiceImpl implements IOrderPicService 
{
    @Autowired
    private OrderPicMapper orderPicMapper;

    /**
     * 查询upload_pic
     * 
     * @param id upload_picID
     * @return upload_pic
     */
    @Override
    public OrderPic selectOrderPicById(Long id)
    {
        return orderPicMapper.selectOrderPicById(id);
    }

    @Override
    public OrderPic findOrderPicByOrderId(Long orderId) {
        return orderPicMapper.findOrderPicByOrderId(orderId);
    }



    /**
     * 查询upload_pic列表
     * 
     * @param orderPic upload_pic
     * @return upload_pic
     */
    @Override
    public List<OrderPic> selectOrderPicList(OrderPic orderPic)
    {
        return orderPicMapper.selectOrderPicList(orderPic);
    }

    /**
     * 新增upload_pic
     * 
     * @param orderPic upload_pic
     * @return 结果
     */
    @Override
    public int insertOrderPic(OrderPic orderPic)
    {
        return orderPicMapper.insertOrderPic(orderPic);
    }

    /**
     * 修改upload_pic
     * 
     * @param orderPic upload_pic
     * @return 结果
     */
    @Override
    public int updateOrderPic(OrderPic orderPic)
    {
        return orderPicMapper.updateOrderPic(orderPic);
    }

    /**
     * 删除upload_pic对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderPicByIds(String ids)
    {
        return orderPicMapper.deleteOrderPicByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除upload_pic信息
     * 
     * @param id upload_picID
     * @return 结果
     */
    @Override
    public int deleteOrderPicById(Long id)
    {
        return orderPicMapper.deleteOrderPicById(id);
    }
}
