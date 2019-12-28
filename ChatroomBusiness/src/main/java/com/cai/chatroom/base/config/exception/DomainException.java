package com.cai.chatroom.base.config.exception;

public class DomainException extends BusinessException{
    public DomainException() {
    }

    public DomainException(String message) {
        super(message);
    }
}
