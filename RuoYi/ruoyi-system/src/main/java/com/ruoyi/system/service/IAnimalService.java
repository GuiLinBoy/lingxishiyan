package com.ruoyi.system.service;

import com.ruoyi.system.domain.Animal;

import java.util.List;

/**
 * animalService接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface IAnimalService 
{
    /**
     * 查询animal
     * 
     * @param id animalID
     * @return animal
     */
    public Animal selectAnimalById(Long id);

    /**
     * 查询animal列表
     * 
     * @param animal animal
     * @return animal集合
     */
    public List<Animal> selectAnimalList(Animal animal);

    /**
     * 新增animal
     * 
     * @param animal animal
     * @return 结果
     */
    public int insertAnimal(Animal animal);

    /**
     * 修改animal
     * 
     * @param animal animal
     * @return 结果
     */
    public int updateAnimal(Animal animal);

    /**
     * 批量删除animal
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAnimalByIds(String ids);

    /**
     * 删除animal信息
     * 
     * @param id animalID
     * @return 结果
     */
    public int deleteAnimalById(Long id);

    Animal findAnimalByOrderId(Long orderId,Long orderIf);
}
