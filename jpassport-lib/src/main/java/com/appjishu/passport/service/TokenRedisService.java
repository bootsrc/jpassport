package com.appjishu.passport.service;

import com.appjishu.passport.redis.CommonCacheKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


/**
 * @author liushaoming(liushaomingdev @ 163.com)
 * @version 创建时间：2017年8月27日 下午8:08:19
 * 类说明
 */
@Service
public class TokenRedisService {
    private static final Logger logger = LoggerFactory.getLogger(TokenRedisService.class);

    @Autowired
    private JedisPool jedisPool;

    public String getToken(Long userId) {
        Jedis jedis = jedisPool.getResource();
        String key = CommonCacheKey.PASSPORT_PREFIX + userId;
        String tokenInRedis = jedis.get(key);
        jedis.close();
        logger.info("TokenRedisService.getToken:key={},value={}", new Object[]{key, tokenInRedis});
        return tokenInRedis;
    }

    public String setToken(Long userId, String token) {
        String key = CommonCacheKey.PASSPORT_PREFIX + userId;
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key, token);
        jedis.close();
        logger.info("TokenRedisService.setToken:key={},value={}", new Object[]{key, token});
        return result;
    }
}
