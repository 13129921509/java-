package com.cai.chatroom.service;

import com.cai.chatroom.entity.ChatRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRecordRepository extends JpaRepository<ChatRecord, Long> {

}
