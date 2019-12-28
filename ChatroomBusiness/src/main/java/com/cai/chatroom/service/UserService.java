package com.cai.chatroom.service;

import com.cai.chatroom.base.BeforeAndAfterOperation;
import com.cai.chatroom.base.config.BaseService;
import com.cai.chatroom.base.config.RedisService;
import com.cai.chatroom.base.genarate.ResponseMessageFactory;
import com.cai.chatroom.constants.ChatMessage;
import com.cai.chatroom.constants.UserMessage;
import com.cai.chatroom.domain.OnlineUser;
import com.cai.chatroom.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cai.chatroom.base.genarate.ResponseMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
public class UserService extends BaseService<User> implements BeforeAndAfterOperation<User> {
    @Autowired
    UserRepository userRepository;

    @Override
    public void cache(User user) {
        //缓存在线用户
        OnlineUser onlineUser = new OnlineUser(user.getId(), user);
        jedis().set(onlineUser.getCacheKeyByUserId(), RedisService.serialize(onlineUser));
        jedis().set(onlineUser.getCacheKeyByUuId(), RedisService.serialize(onlineUser));
    }

    public ResponseMessage login(HttpServletRequest request, User user){

        if (!userRepository.existsUserByUsername(user.getUsername())){
            return ResponseMessageFactory.error(UserMessage.UM_0001);
        }
        if (!userRepository.existsUserByUsernameAndPassword(user.getUsername(),user.getPassword())){
            return ResponseMessageFactory.error(UserMessage.UM_0002);
        }
        user = userRepository.getByUsernameAndPassword(user.getUsername(),user.getPassword());
        user.define();
        RLock lock = redisLock().getAndTryLock(user.DEFINE.get("cache_key"));
        try{
            if (lock == null){
                log.error("-------"+user.DEFINE.get("cache_key"));
                return ResponseMessageFactory.error(ChatMessage.CHAT_0001);
            }
            if (!userRepository.existsUserByUsernameAndPasswordAndLocked(user.getUsername(),user.getPassword(),0)){
                return ResponseMessageFactory.error(UserMessage.UM_0003);
            }
            template().beginTransaction();
            template().update("update user set locked = 1 where username = ?",user.getUsername());
            cache(user);
            template().commit();
            OnlineUser onlineUser = RedisService.unSerialize(jedis().get(OnlineUser.getCacheKeyByUserId(user.getId())),OnlineUser.class);
            return ResponseMessageFactory.success(null, onlineUser.getUuid());
        }catch (Throwable t){
            template().rollback();
            t.printStackTrace();
            return ResponseMessageFactory.error(t.getMessage());
        }finally {
            if (lock != null) redisLock().unlock(lock);
        }
    }

    public ResponseMessage existUser(HttpServletRequest request, User user){
        if (userRepository.existsUserByUsername(user.getUsername())){
            return ResponseMessageFactory.error(UserMessage.UM_0005);
        }else{
            return ResponseMessageFactory.success();
        }
    }

    public ResponseMessage register(HttpServletRequest request, User user){
        user.define();
        RLock lock = redisLock().getAndTryLock(user.DEFINE.get("createUser_cache_key"));
        if (lock == null){
            return ResponseMessageFactory.error(ChatMessage.CHAT_0001);
        }
        try {
            if (userRepository.existsUserByUsername(user.getUsername())){
                return ResponseMessageFactory.error(UserMessage.UM_0005);
            }
            if (userRepository.save(user) != null){
                return ResponseMessageFactory.success();
            }else{
                return ResponseMessageFactory.error(UserMessage.UM_0007);
            }
        }catch (Throwable t){
            t.printStackTrace();
            return ResponseMessageFactory.error(t.getMessage());
        }finally {
            if (lock != null) redisLock().unlock(lock);
        }
    }
}
