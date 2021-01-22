package com.ruoyi.web.controller.weChat;

import com.ruoyi.system.domain.Notepad;
import com.ruoyi.system.service.INotepadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.soap.Addressing;
import java.util.List;

/**
 * @Classname weChatNotePad
 * @Author ZhangGY
 * @Date 2021/1/9 23:44
 **/
@RestController
@RequestMapping("/weChat")
public class weChatNotePad {

    @Autowired
    private INotepadService notepadService;


    @ResponseBody
    @RequestMapping("/findNotePadById")
    public Notepad findNotePadById(Integer id){
        if (id != null){
            return notepadService.selectNotepadById(id.longValue());
        }else return null;
    }



    @ResponseBody
    @RequestMapping("/findNotePadByUserId")
    public List<Notepad> findNotePadByUserId(Integer userId){
        if (userId != null) {
            return notepadService.findNotePadByUserId(userId);
        }   else return null;
    }

    @ResponseBody
    @RequestMapping("/saveAndUpdateNotePad")
    public int saveAndUpdateNotePad(Notepad notepad){
        if (notepad != null) {
            return notepadService.saveAndUpdateNotePad(notepad);
        }else return -1;
    }
}
