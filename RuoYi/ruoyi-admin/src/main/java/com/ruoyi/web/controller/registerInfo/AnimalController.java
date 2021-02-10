package com.ruoyi.web.controller.registerInfo;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Animal;
import com.ruoyi.system.service.IAnimalService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * animalController
 * 
 * @author ruoyi
 * @date 2021-01-24
 */
@Controller
@RequestMapping("/system/animal")
public class AnimalController extends BaseController
{
    private String prefix = "system/animal";

    @Autowired
    private IAnimalService animalService;

    @RequiresPermissions("system:animal:view")
    @GetMapping()
    public String animal()
    {
        return prefix + "/animal";
    }

    /**
     * 查询animal列表
     */
    @RequiresPermissions("system:animal:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Animal animal)
    {
        startPage();
        List<Animal> list = animalService.selectAnimalList(animal);
        return getDataTable(list);
    }

    /**
     * 导出animal列表
     */
    @RequiresPermissions("system:animal:export")
    @Log(title = "animal", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Animal animal)
    {
        List<Animal> list = animalService.selectAnimalList(animal);
        ExcelUtil<Animal> util = new ExcelUtil<Animal>(Animal.class);
        return util.exportExcel(list, "animal");
    }

    /**
     * 新增animal
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存animal
     */
    @RequiresPermissions("system:animal:add")
    @Log(title = "animal", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Animal animal)
    {
        return toAjax(animalService.insertAnimal(animal));
    }

    /**
     * 修改animal
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        Animal animal = animalService.selectAnimalById(id);
        mmap.put("animal", animal);
        return prefix + "/edit";
    }

    /**
     * 修改保存animal
     */
    @RequiresPermissions("system:animal:edit")
    @Log(title = "animal", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Animal animal)
    {
        return toAjax(animalService.updateAnimal(animal));
    }

    /**
     * 删除animal
     */
    @RequiresPermissions("system:animal:remove")
    @Log(title = "animal", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(animalService.deleteAnimalByIds(ids));
    }
}
