package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.OrderInfoMapper;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired
    private IAntibodyService antibodyService;

    @Autowired
    private IPlasmidService plasmidService;

    @Autowired
    private ICellService cellService;

    @Autowired
    private IOrderPicService orderPicService;
    @Autowired
    private IMicrobialService microbialService;
    @Autowired
    private IAnimalService animalService;
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
    public List<OrderInfo> searchOrderData(List<Integer> userIdList, String searchTem) {
        return orderInfoMapper.searchOrderData(userIdList,searchTem);
    }

    @Override
    public int findOrderCount(Integer checkUserId) {
        return orderInfoMapper.findOrderCount(checkUserId.longValue());
    }

    @Override
    public Antibody findAntiBodyByOrderId(Integer orderId) {
        return antibodyService.findAntiBodyByOrderId(orderId.longValue(),1L);
    }

    @Override
    public Plasmid findPlasmidByOrderId(Integer orderId) {
        return plasmidService.findPlasmidByOrderId(orderId.longValue(),1L);
    }

    @Override
    public Cell findCellByOrderId(Integer orderId) {
        return cellService.findCellByOrderId(orderId.longValue(),1L);
    }

    @Override
    public Microbial findMicrobialByOrderId(Integer orderId) {
        return microbialService.findMicrobialByOrderId(orderId.longValue(),1L);
    }

    @Override
    public Animal findAnimalByOrderId(Integer orderId) {
        return animalService.findAnimalByOrderId(orderId.longValue(),1L);
    }

    @Override
    public OrderPic findOrderPicByOrderId(Integer orderId) {
        return orderPicService.findOrderPicByOrderId(orderId.longValue());
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
    public OrderAndSanFang selectOrderInfoByOrderUserId(Integer OrderUserId,Integer checkState) {

        if (OrderUserId != null) {
            List<OrderInfo> orderInfoList = null;
            if (checkState != -1){
                orderInfoList = orderInfoMapper.selectOrderInfoByOrderUserIdAndcheckState(OrderUserId,checkState);
            }else {
                orderInfoList = orderInfoMapper.selectOrderInfoByOrderUserId(OrderUserId);
            }

            OrderAndSanFang orderAndSanFang = new OrderAndSanFang();
            orderAndSanFang.setOrderInfoList(orderInfoList);
            return orderAndSanFang;
        }else return null;
    }

    @Override
    public OrderAndSanFang selectOrderInfoByOrderUserId(Integer orderUserId, Integer checkUserId,Integer checkState) {
        if (orderUserId != null) {
            List<OrderInfo> orderInfoList = null;
            if (checkState != -1){
                orderInfoList = orderInfoMapper.selectOrderInfoByOrderUserAndCheckState(orderUserId,checkUserId,checkState);
            }else {
                orderInfoList = orderInfoMapper.selectOrderInfoByOrderUserAndCheck(orderUserId,checkUserId);
            }
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


    @Transactional
    @Override
    public List<Userinfo> findUserByCheckUser(Integer checkUserId,Integer checkState) {
        if(checkUserId == null || checkState == null){
            return null;
        }
        List<OrderInfo> orderInfoList = null;
        if (checkState != -1){
            orderInfoList = orderInfoMapper.selectOrderInfoByCheckUserIdAndState(checkUserId,checkState);
        }else {
            orderInfoList = orderInfoMapper.selectOrderInfoByCheckUserId(checkUserId);
        }
        List<Integer> userIdList = new ArrayList<Integer>();
        if(orderInfoList.size() == 0) return null;
        for (OrderInfo orderInfo : orderInfoList){
            Long orderUser = orderInfo.getOrderUser();
            if (orderUser != null){
                userIdList.add(orderInfo.getOrderUser().intValue());
            }
        }
        List<Userinfo> userList = userinfoService.selectRealNameByIds(userIdList);
        return userList;
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

    @Transactional
    @Override
    public int saveAndUpdateOrder(OrderAndSanFang orderAndSanFang) {
        OrderInfo orderInfo = orderAndSanFang.getOrderInfo();
        Integer orderId = null;
        if (orderInfo.getId() != null) {
             this.updateOrderInfo(orderInfo);
        }else {
             this.insertOrderInfo(orderInfo);
        }
        orderId = orderInfo.getId().intValue();
        List<SanfangInfo> sanFangInfoList = orderAndSanFang.getSanFangInfoList();
        if (sanFangInfoList != null){
            for (SanfangInfo sanfangInfo : sanFangInfoList){
                if (sanfangInfo.getId() != null) {
                    sanFangInfoService.updateSanfangInfo(sanfangInfo);
                }else {
                    sanfangInfo.setOrderid(orderId);
                    sanFangInfoService.insertSanfangInfo(sanfangInfo);
                }
            }
        }
        if (orderAndSanFang.getAntibody() != null){
            Antibody antibody = orderAndSanFang.getAntibody();
            if(antibody.getId()== null){
                antibody.setRegisterId(orderId.longValue());
                antibodyService.insertAntibody(antibody);
            }else {
                antibodyService.updateAntibody(antibody);
            }
        }
        if (orderAndSanFang.getPlasmid() != null){
            Plasmid plasmid = orderAndSanFang.getPlasmid();
            if(plasmid.getId()== null){
                plasmid.setRegisterId(orderId.longValue());
                plasmidService.insertPlasmid(plasmid);
            }else {
                plasmidService.updatePlasmid(plasmid);
            }
        }
        if (orderAndSanFang.getCell() != null){
            Cell cell = orderAndSanFang.getCell();
            if(cell.getId()== null){
                cell.setRegisterId(orderId.longValue());
                cellService.insertCell(cell);
            }else {
                cellService.updateCell(cell);
            }
        }
        if (orderAndSanFang.getMicrobial() != null){
            Microbial microbial = orderAndSanFang.getMicrobial();
            if(microbial.getId()== null){
                microbial.setRegisterId(orderId.longValue());
                microbialService.insertMicrobial(microbial);
            }else {
                microbialService.updateMicrobial(microbial);
            }
        }
        if (orderAndSanFang.getAnimal() !=null){
            Animal animal = orderAndSanFang.getAnimal();
            if(animal.getId()== null){
                animal.setRegisterId(orderId.longValue());
                animalService.insertAnimal(animal);
            }else {
                animalService.updateAnimal(animal);
            }
        }
        if (orderAndSanFang.getOrderPic() != null){
            OrderPic orderPic = orderAndSanFang.getOrderPic();
            orderPic.setOrderId(orderId.longValue());
            orderPicService.insertOrderPic(orderPic);
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
