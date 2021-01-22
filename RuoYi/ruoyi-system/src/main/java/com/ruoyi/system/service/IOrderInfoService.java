package com.ruoyi.system.service;

import com.ruoyi.system.domain.OrderAndSanFang;
import com.ruoyi.system.domain.OrderInfo;

import java.util.List;

/**
 * orderInfoService接口
 * 
 * @author ruoyi
 * @date 2021-01-13
 */
public interface IOrderInfoService 
{
    /**
     * 查询orderInfo
     * 
     * @param id orderInfoID
     * @return orderInfo
     */
    public OrderInfo selectOrderInfoById(Long id);

    /**
     * 查询orderInfo列表
     * 
     * @param orderInfo orderInfo
     * @return orderInfo集合
     */
    public List<OrderInfo> selectOrderInfoList(OrderInfo orderInfo);

    /**
     * 新增orderInfo
     * 
     * @param orderInfo orderInfo
     * @return 结果
     */
    public int insertOrderInfo(OrderInfo orderInfo);

    /**
     * 修改orderInfo
     * 
     * @param orderInfo orderInfo
     * @return 结果
     */
    public int updateOrderInfo(OrderInfo orderInfo);

    /**
     * 批量删除orderInfo
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderInfoByIds(String ids);

    /**
     * 删除orderInfo信息
     * 
     * @param id orderInfoID
     * @return 结果
     */
    public int deleteOrderInfoById(Long id);

    OrderAndSanFang selectOrderInfoByCheckUserId(Integer checkUserId);


    OrderAndSanFang selectOrderInfoByOrderUserId(Integer OrderUserId);

    int saveAndUpdateOrder(OrderAndSanFang orderAndSanFang);

    int updateCheckState(Integer id, Integer checkState);
}
