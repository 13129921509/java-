package com.cai.chatroom.controller;

import com.cai.chatroom.service.ChatRecordService;
import com.cai.chatroom.entity.ChatRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "chatRecord")
public class ChatRecordController {

    @Autowired
    ChatRecordService chatRecordDao;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public void test2(){
        System.out.println("test2 success!!!");
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public void test(@RequestParam("sid") String sid, @RequestParam("path") String path){
//        ChatRecord cr = new ChatRecord(String.valueOf(body.get("sid")),String.valueOf(body.get("path")));
        ChatRecord cr = new ChatRecord(sid,path);

        chatRecordDao.save(cr);
    }
}
