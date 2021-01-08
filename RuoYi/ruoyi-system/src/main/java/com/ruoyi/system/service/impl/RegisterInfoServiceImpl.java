package com.ruoyi.system.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RegisterInfoMapper;
import com.ruoyi.system.domain.RegisterInfo;
import com.ruoyi.system.service.IRegisterInfoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 登记信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-04
 */
@Service
public class RegisterInfoServiceImpl implements IRegisterInfoService 
{
    @Autowired
    private RegisterInfoMapper registerInfoMapper;

    /**
     * 查询登记信息
     * 
     * @param id 登记信息ID
     * @return 登记信息
     */
    @Override
    public RegisterInfo selectRegisterInfoById(Long id)
    {
        return registerInfoMapper.selectRegisterInfoById(id);
    }

    @Override
    public List<RegisterInfo> selectRegisterInfoByUserId(Integer registerUser) {
        if (registerUser != null){
            return registerInfoMapper.selectRegisterInfoByUserId(registerUser);
        }
        return null;
    }

    @Override
    public int saveAndUpdateRegisterInfo(RegisterInfo registerInfo) {
        if (registerInfo.getId() != null){
            return registerInfoMapper.updateRegisterInfo(registerInfo);
        }else
            return registerInfoMapper.insertRegisterInfo(registerInfo);
    }

    /**
     * 查询登记信息列表
     * 
     * @param registerInfo 登记信息
     * @return 登记信息
     */
    @Override
    public List<RegisterInfo> selectRegisterInfoList(RegisterInfo registerInfo)
    {
        return registerInfoMapper.selectRegisterInfoList(registerInfo);
    }

    /**
     * 新增登记信息
     * 
     * @param registerInfo 登记信息
     * @return 结果
     */
    @Override
    public int insertRegisterInfo(RegisterInfo registerInfo)
    {
        return registerInfoMapper.insertRegisterInfo(registerInfo);
    }

    /**
     * 修改登记信息
     * 
     * @param registerInfo 登记信息
     * @return 结果
     */
    @Override
    public int updateRegisterInfo(RegisterInfo registerInfo)
    {
        return registerInfoMapper.updateRegisterInfo(registerInfo);
    }

    /**
     * 删除登记信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteRegisterInfoByIds(String ids)
    {
        return registerInfoMapper.deleteRegisterInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除登记信息信息
     * 
     * @param id 登记信息ID
     * @return 结果
     */
    @Override
    public int deleteRegisterInfoById(Long id)
    {
        return registerInfoMapper.deleteRegisterInfoById(id);
    }
}
