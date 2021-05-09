package com.chris.service;

import lombok.extern.slf4j.Slf4j;
import org.simpleframework.xml.core.Commit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;


/**
 * redis 实现分布式锁
 */
@Commit
@Slf4j
public class RedisLock {

    private static final Logger log= LoggerFactory.getLogger(RedisLock.class);

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * 1.setnx(lockkey, 当前时间+过期超时时间) ，如果返回1，则获取锁成功；如果返回0则没有获取到锁，转向2。
     * 2.get(lockkey)获取值oldExpireTime ，并将这个value值与当前的系统时间进行比较，如果小于当前系统时间，
     * 则认为这个锁已经超时，可以允许别的请求重新获取，转向3。
     * 3.计算newExpireTime=当前时间+过期超时时间，然后getset(lockkey, newExpireTime) 会返回当前lockkey的
     * 值currentExpireTime。
     * 4.判断currentExpireTime与oldExpireTime 是否相等，如果相等，说明当前getset设置成功，获取到了锁。如果不相等，
     * 说明这个锁又被别的请求获取走了，那么当前请求可以直接返回失败，或者继续重试。
     * 5.在获取到锁之后，当前线程可以开始自己的业务处理，当处理完毕后，比较自己的处理时间和对于锁设置的超时时间，
     * 如果小于锁设置的超时时间，则直接执行delete释放锁；如果大于锁设置的超时时间，则不需要再锁进行处理。
     * @param key
     * @param value  当前时间+过期时间
     * @return
     */
    public boolean lock(String key,String value){
        if(redisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }

        String currentValue=redisTemplate.opsForValue().get(key);

        if(!StringUtils.isEmpty(currentValue)&&Long.parseLong(currentValue)<System.currentTimeMillis()){
            String oldValue=redisTemplate.opsForValue().getAndSet(key,value);
            if(!StringUtils.isEmpty(oldValue)&&oldValue.equals(currentValue))
                return true;
        }
        return false;
    }


    public void unlock(String key,String value){
        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis())
                redisTemplate.opsForValue().getOperations().delete(key);
        }catch (Exception e){
            log.error("redis unlock failed");
        }
    }

}
