package com.appjishu.passport.redis;

import java.io.Serializable;

/**
 * 标识接口 声明实现此接口的bean，客户通过 MobileUserDataCacheJedisPoolImpl 类 save，get方法缓存到redis服务器
 * 
 * @author liushaoming(liushaomingdev@163.com)
 * 
 */
public interface RedisCacheable extends Serializable
{
    
}
