package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.RegisterInfo;
import com.ruoyi.system.domain.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 登记信息Mapper接口
 * 
 * @author ruoyi
 * @date 2021-01-09
 */
@Mapper
public interface RegisterInfoMapper 
{
    /**
     * 查询登记信息
     * 
     * @param id 登记信息ID
     * @return 登记信息
     */
    public RegisterInfo selectRegisterInfoById(Long id);

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
     * 删除登记信息
     * 
     * @param id 登记信息ID
     * @return 结果
     */
    public int deleteRegisterInfoById(Long id);

    /**
     * 批量删除登记信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteRegisterInfoByIds(String[] ids);

    List<RegisterInfo> selectRegisterInfoByUserId(Integer registerUser);

    List<RegisterInfo> selectRegisterByUserId(@Param("userinfoList") List<Userinfo> userinfoList);

    List<RegisterInfo> searchRegisterData(@Param("userIdList") List<Integer> userIdList,@Param("searchTem") String searchTem);
}
