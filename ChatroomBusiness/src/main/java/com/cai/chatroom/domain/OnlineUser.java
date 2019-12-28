package com.cai.chatroom.domain;

import com.cai.chatroom.base.BaseDomain;
import com.cai.chatroom.base.config.exception.BusinessException;
import com.cai.chatroom.base.config.exception.DomainException;
import com.cai.chatroom.constants.UserMessage;
import com.cai.chatroom.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 *
 */
@Data
@NoArgsConstructor
public class OnlineUser extends BaseDomain {
    public static String cache_key_prefix = OnlineUser.class.getName()+":";

    public OnlineUser(long userId, User user) {
        this.userId = userId;
        this.user = user;
        this.uuid = UUID.randomUUID().toString();
        setCacheKeyByUserId();
        setCacheKey();
        setCacheKeyByUuId();
    }

    @Override
    protected void setCacheKeyByUserId() {
        this.cacheKeyByUserId = cache_key_prefix+this.userId;
    }

    @Override
    protected void setCacheKeyByUuId() {
        this.cacheKeyByUuId = cache_key_prefix+this.uuid;
    }

    long userId;

    User user;

    String uuid;

    public static String getCacheKeyByUserId(Long userId){
        return cache_key_prefix+userId;
    }

    public static String getCacheKeyByUuid(String uuid){
        return cache_key_prefix+uuid;
    }

}
