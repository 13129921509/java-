package com.cai.chatroom.base.config;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class RedisLockService {
    @Autowired
    RedissonClient redissonClient;

    public RLock lock(String key){
        RLock lock = redissonClient.getLock(key);
        lock.lock();
        return lock;
    }

    public synchronized RLock getAndTryLock(String key){
        RLock lock = redissonClient.getLock(key);
        try {
            boolean s = lock.tryLock();
            if (s == true)
                return lock;
            else
                return null;
        }catch (Throwable t){
            return null;
        }
    }


    public synchronized void unlock(RLock lock){
        lock.unlock();
    }

    public void unlock(String key){
        RLock lock = redissonClient.getLock(key);
        lock.unlock();
    }
}
