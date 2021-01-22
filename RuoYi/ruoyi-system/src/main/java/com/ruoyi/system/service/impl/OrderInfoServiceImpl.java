package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.OrderAndSanFang;
import com.ruoyi.system.domain.OrderInfo;
import com.ruoyi.system.domain.SanfangInfo;
import com.ruoyi.system.mapper.OrderInfoMapper;
import com.ruoyi.system.service.IOrderInfoService;
import com.ruoyi.system.service.ISanfangInfoService;
import com.ruoyi.system.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * orderInfoService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-13
 */
@Service
public class OrderInfoServiceImpl implements IOrderInfoService 
{
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Autowired
    private ISanfangInfoService sanFangInfoService;
    @Autowired
    private IUserinfoService userinfoService;

    /**
     * 查询orderInfo
     * 
     * @param id orderInfoID
     * @return orderInfo
     */
    @Override
    public OrderInfo selectOrderInfoById(Long id)
    {
        OrderInfo orderInfoTem = orderInfoMapper.selectOrderInfoById(id);
        String checkUserName = userinfoService.selectUserinfoById(orderInfoTem.getCheckUser()).getRealname();
        String orderName = userinfoService.selectUserinfoById(orderInfoTem.getOrderUser()).getRealname();
        orderInfoTem.setCheckUserName(checkUserName);
        orderInfoTem.setOrderUserName(orderName);
        return orderInfoTem;
    }

    @Override
    public OrderAndSanFang selectOrderInfoByCheckUserId(Integer checkUserId) {
        if (checkUserId != null) {
            List<OrderInfo> orderInfoList = orderInfoMapper.selectOrderInfoByCheckUserId(checkUserId);
            OrderAndSanFang orderAndSanFang = new OrderAndSanFang();
            orderAndSanFang.setOrderInfoList(orderInfoList);
            return orderAndSanFang;
        }else return null;
    }

    @Override
    public OrderAndSanFang selectOrderInfoByOrderUserId(Integer OrderUserId) {

        if (OrderUserId != null) {
            List<OrderInfo> orderInfoList = orderInfoMapper.selectOrderInfoByOrderUserId(OrderUserId);
            OrderAndSanFang orderAndSanFang = new OrderAndSanFang();
            orderAndSanFang.setOrderInfoList(orderInfoList);
            return orderAndSanFang;
        }else return null;
    }

    /**
     * 查询orderInfo列表
     * 
     * @param orderInfo orderInfo
     * @return orderInfo
     */
    @Override
    public List<OrderInfo> selectOrderInfoList(OrderInfo orderInfo)
    {
        List<OrderInfo> orderInfoList = orderInfoMapper.selectOrderInfoList(orderInfo);
        for (OrderInfo orderInfoTem: orderInfoList){
            String checkUserName = userinfoService.selectUserinfoById(orderInfoTem.getCheckUser()).getRealname();
            String orderName = userinfoService.selectUserinfoById(orderInfoTem.getOrderUser()).getRealname();
            orderInfoTem.setCheckUserName(checkUserName);
            orderInfoTem.setOrderUserName(orderName);
        }
        return orderInfoList;
    }

    /**
     * 新增orderInfo
     * 
     * @param orderInfo orderInfo
     * @return 结果
     */
    @Override
    public int insertOrderInfo(OrderInfo orderInfo)
    {
        return orderInfoMapper.insertOrderInfo(orderInfo);
    }

    @Override
    public int saveAndUpdateOrder(OrderAndSanFang orderAndSanFang) {
        OrderInfo orderInfo = orderAndSanFang.getOrderInfo();
        if (orderInfo.getId() != null) {
             this.updateOrderInfo(orderInfo);
        }else {
            this.insertOrderInfo(orderInfo);
        }
        List<SanfangInfo> sanFangInfoList = orderAndSanFang.getSanFangInfoList();
        for (SanfangInfo sanfangInfo : sanFangInfoList){
            if (sanfangInfo.getId() != null) {
                sanFangInfoService.updateSanfangInfo(sanfangInfo);
            }else {
                sanFangInfoService.insertSanfangInfo(sanfangInfo);
            }
        }
        return 0;
    }

    @Override
    public int updateCheckState(Integer id, Integer checkState) {

        OrderInfo orderInfo = this.selectOrderInfoById(id.longValue());
        orderInfo.setCheckstate(checkState);
        return this.updateOrderInfo(orderInfo);
    }

    /**
     * 修改orderInfo
     * 
     * @param orderInfo orderInfo
     * @return 结果
     */
    @Override
    public int updateOrderInfo(OrderInfo orderInfo)
    {
        return orderInfoMapper.updateOrderInfo(orderInfo);
    }

    /**
     * 删除orderInfo对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteOrderInfoByIds(String ids)
    {
        return orderInfoMapper.deleteOrderInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除orderInfo信息
     * 
     * @param id orderInfoID
     * @return 结果
     */
    @Override
    public int deleteOrderInfoById(Long id)
    {
        return orderInfoMapper.deleteOrderInfoById(id);
    }
}
