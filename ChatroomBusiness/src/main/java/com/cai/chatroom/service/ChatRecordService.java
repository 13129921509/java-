package com.cai.chatroom.service;


import com.cai.chatroom.entity.ChatRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ChatRecordService {
    @Autowired
    ChatRecordRepository chatRecordRepository;


    @Transactional
    public void save(ChatRecord cr){
        chatRecordRepository.saveAndFlush(cr);
    }
}
