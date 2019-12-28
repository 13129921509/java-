package com.cai.chatroom.base.config;

public interface TransactionAction{
    void action(JdbcTemplate template);
}