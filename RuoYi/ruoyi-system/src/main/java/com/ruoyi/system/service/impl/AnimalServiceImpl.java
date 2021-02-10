package com.ruoyi.system.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.domain.Animal;
import com.ruoyi.system.mapper.AnimalMapper;
import com.ruoyi.system.service.IAnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * animalService业务层处理
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Service
public class AnimalServiceImpl implements IAnimalService 
{
    @Autowired
    private AnimalMapper animalMapper;

    /**
     * 查询animal
     * 
     * @param id animalID
     * @return animal
     */
    @Override
    public Animal selectAnimalById(Long id)
    {
        return animalMapper.selectAnimalById(id);
    }


    @Override
    public Animal findAnimalByOrderId(Long orderId, Long orderIf) {
        return animalMapper.findAnimalByOrderId(orderId,orderIf);
    }

    /**
     * 查询animal列表
     * 
     * @param animal animal
     * @return animal
     */
    @Override
    public List<Animal> selectAnimalList(Animal animal)
    {
        return animalMapper.selectAnimalList(animal);
    }

    /**
     * 新增animal
     * 
     * @param animal animal
     * @return 结果
     */
    @Override
    public int insertAnimal(Animal animal)
    {
        return animalMapper.insertAnimal(animal);
    }

    /**
     * 修改animal
     * 
     * @param animal animal
     * @return 结果
     */
    @Override
    public int updateAnimal(Animal animal)
    {
        return animalMapper.updateAnimal(animal);
    }

    /**
     * 删除animal对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAnimalByIds(String ids)
    {
        return animalMapper.deleteAnimalByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除animal信息
     * 
     * @param id animalID
     * @return 结果
     */
    @Override
    public int deleteAnimalById(Long id)
    {
        return animalMapper.deleteAnimalById(id);
    }
}
