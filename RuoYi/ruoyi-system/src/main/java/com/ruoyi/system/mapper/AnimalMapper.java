package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.Animal;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * animalMapper接口
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
public interface AnimalMapper 
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
     * 删除animal
     * 
     * @param id animalID
     * @return 结果
     */
    public int deleteAnimalById(Long id);

    /**
     * 批量删除animal
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAnimalByIds(String[] ids);

    Animal findAnimalByOrderId(@Param("orderId") Long orderId, @Param("orderIf") Long orderIf);
}
