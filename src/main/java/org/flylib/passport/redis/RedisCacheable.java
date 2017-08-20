package org.flylib.passport.redis;

import java.io.Serializable;

/**
 * 标识接口 声明实现此接口的bean，客户通过 MobileUserDataCacheJedisPoolImpl 类 save，get方法缓存到redis服务器
 * 
 * @author 会员
 * 
 */
public interface RedisCacheable extends Serializable
{
    
}
