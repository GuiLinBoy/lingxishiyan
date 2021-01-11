package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.RegisterInfo;
import com.ruoyi.system.domain.Userinfo;
import com.ruoyi.system.mapper.RegisterInfoMapper;
import com.ruoyi.system.service.IRegisterInfoService;
import com.ruoyi.system.service.IUserinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 登记信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
@Service
public class RegisterInfoServiceImpl implements IRegisterInfoService 
{
    @Autowired
    private RegisterInfoMapper registerInfoMapper;

    @Autowired
    private IUserinfoService userinfoService;
    /**
     * 查询登记信息
     * 
     * @param id 登记信息ID
     * @return 登记信息
     */
    @Override
    public List selectRegisterInfoById(Long id)
    {
        RegisterInfo registerInfo = registerInfoMapper.selectRegisterInfoById(id);
        Userinfo userinfo = userinfoService.selectUserinfoById(registerInfo.getRegisterUser());
        String realName = userinfo.getRealname();
        registerInfo.setRegisterUserName(realName);

        List<Userinfo> userinfoList = userinfoService.findUserByGroupIdAunitid(userinfo.getUnitid().intValue(), userinfo.getResearchGroupId().intValue());
        List list = new ArrayList();
        list.add(registerInfo);
        list.add(userinfoList);
        return list;
    }

    @Override
    public List<RegisterInfo> selectRegisterInfoByUserId(Integer registerUser) {
        if (registerUser != null){
            return registerInfoMapper.selectRegisterInfoByUserId(registerUser);
        }
        return null;
    }


    /**
     * @Author ZhangGY
     * @Description //TODO 根据每个用户的登记信息（传入用户列表，）
     * @Date 21:43 2021/1/9
     * @Param [userinfoList]
     * @return java.util.List<com.ruoyi.system.domain.RegisterInfo>
     *
     **/
    @Override
    public List<RegisterInfo> selectRegisterByUserId(List<Userinfo> userinfoList) {
        return registerInfoMapper.selectRegisterByUserId(userinfoList);
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
        List<RegisterInfo> registerInfos = registerInfoMapper.selectRegisterInfoList(registerInfo);
        for (RegisterInfo registerInfoTem : registerInfos){
            String realName = userinfoService.selectUserinfoById(registerInfoTem.getRegisterUser()).getRealname();
            registerInfoTem.setRegisterUserName(realName);
        }
        return registerInfos;
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
