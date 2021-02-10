package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.mapper.RegisterInfoMapper;
import com.ruoyi.system.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private IAntibodyService antibodyService;

    @Autowired
    private IUserinfoService userinfoService;

    @Autowired
    private IPlasmidService plasmidService;

    @Autowired
    private ICellService cellService;

    @Autowired
    private IMicrobialService microbialService;
    @Autowired
    private IAnimalService animalService;
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

        List<Userinfo> userinfoList = userinfoService.findUserByGroupIdAunitid(-1,userinfo.getUnitid().intValue(), userinfo.getResearchGroupId().intValue());
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
    public List<RegisterInfo> searchRegisterData(List<Integer> userIdList, String searchTem) {
        return registerInfoMapper.searchRegisterData(userIdList,searchTem);
    }

    @Override
    public Antibody findAntiBodyByOrderId(Integer registerId) {
        return antibodyService.findAntiBodyByOrderId(registerId.longValue(),0L);
    }

    @Override
    public Plasmid findPlasmidByOrderId(Integer registerId) {
        return plasmidService.findPlasmidByOrderId(registerId.longValue(),0L);
    }

    @Override
    public Cell findCellByOrderId(Integer registerId) {
        return cellService.findCellByOrderId(registerId.longValue(),0L);
    }

    @Override
    public Microbial findMicrobialByOrderId(Integer registerId) {
        return microbialService.findMicrobialByOrderId(registerId.longValue(),0L);
    }

    @Override
    public Animal findAnimalByOrderId(Integer registerId) {
        return animalService.findAnimalByOrderId(registerId.longValue(),0L);
    }

    @Transactional
    @Override
    public int saveAndUpdateRegisterInfo(RegisterInfoTool registerInfoTool) {
        RegisterInfo registerInfo = registerInfoTool.getRegisterInfo();
        Integer registerId = null;
        if ( registerInfo.getId()!= null){
            registerInfoMapper.updateRegisterInfo(registerInfo);
        }else
            registerInfoMapper.insertRegisterInfo(registerInfo);
        registerId = registerInfo.getId().intValue();
        if (registerInfoTool.getAntibody() != null){
            Antibody antibody = registerInfoTool.getAntibody();
            if(antibody.getId()== null){
                antibody.setRegisterId(registerId.longValue());
                antibodyService.insertAntibody(antibody);
            }else {
                antibodyService.updateAntibody(antibody);
            }
        }
        if (registerInfoTool.getPlasmid() != null){
            Plasmid plasmid = registerInfoTool.getPlasmid();
            if(plasmid.getId()== null){
                plasmid.setRegisterId(registerId.longValue());
                plasmidService.insertPlasmid(plasmid);
            }else {
                plasmidService.updatePlasmid(plasmid);
            }
        }
        if (registerInfoTool.getCell() != null){
            Cell cell = registerInfoTool.getCell();
            if(cell.getId()== null){
                cell.setRegisterId(registerId.longValue());
                cellService.insertCell(cell);
            }else {
                cellService.updateCell(cell);
            }
        }
        if (registerInfoTool.getMicrobial() != null){
            Microbial microbial = registerInfoTool.getMicrobial();
            if(microbial.getId()== null){
                microbial.setRegisterId(registerId.longValue());
                microbialService.insertMicrobial(microbial);
            }else {
                microbialService.updateMicrobial(microbial);
            }
        }
        if (registerInfoTool.getAnimal() !=null){
            Animal animal = registerInfoTool.getAnimal();
            if(animal.getId()== null){
                animal.setRegisterId(registerId.longValue());
                animalService.insertAnimal(animal);
            }else {
                animalService.updateAnimal(animal);
            }
        }
        return registerId;
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
