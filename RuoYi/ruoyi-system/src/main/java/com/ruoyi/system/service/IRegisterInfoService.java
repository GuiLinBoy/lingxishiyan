package com.ruoyi.system.service;

import com.ruoyi.system.domain.*;

import java.util.List;

/**
 * 登记信息Service接口
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
public interface IRegisterInfoService 
{
    /**
     * 查询登记信息
     * 
     * @param id 登记信息ID
     * @return 登记信息
     */
    public List selectRegisterInfoById(Long id);

    /**
     * 查询登记信息列表
     * 
     * @param registerInfo 登记信息
     * @return 登记信息集合
     */
    public List<RegisterInfo> selectRegisterInfoList(RegisterInfo registerInfo);

    /**
     * 新增登记信息
     * 
     * @param registerInfo 登记信息
     * @return 结果
     */
    public int insertRegisterInfo(RegisterInfo registerInfo);

    /**
     * 修改登记信息
     * 
     * @param registerInfo 登记信息
     * @return 结果
     */
    public int updateRegisterInfo(RegisterInfo registerInfo);

    /**
     * 批量删除登记信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRegisterInfoByIds(String ids);

    /**
     * 删除登记信息信息
     * 
     * @param id 登记信息ID
     * @return 结果
     */
    public int deleteRegisterInfoById(Long id);

    List<RegisterInfo> selectRegisterInfoByUserId(Integer registerUser);

    int saveAndUpdateRegisterInfo(RegisterInfoTool registerInfoTool);

    List<RegisterInfo> selectRegisterByUserId(List<Userinfo> userinfoList);

    Antibody findAntiBodyByOrderId(Integer registerId);

    Plasmid findPlasmidByOrderId(Integer registerId);

    Cell findCellByOrderId(Integer registerId);

    Microbial findMicrobialByOrderId(Integer registerId);

    Animal findAnimalByOrderId(Integer registerId);

    List<RegisterInfo> searchRegisterData(List<Integer> userIdList, String searchTem);
}
