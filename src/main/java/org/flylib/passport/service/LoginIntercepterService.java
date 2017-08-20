package org.flylib.passport.service;

import org.flylib.passport.model.Passport;
import org.flylib.passport.redis.CommonCacheKey;
import org.flylib.passport.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;

/** 
* @author Frank Liu(liushaomingdev@163.com)
* @version 创建时间：2017年8月20日 下午2:01:52 
* 类说明 
*/
@Component
public class LoginIntercepterService {
	@Autowired
	private RedisClient redisClient;
	
	public Passport getPassport(String userId) {
		String key = CommonCacheKey.PASSPORT_PREFIX + userId;
		String passportStr = redisClient.get(key);
		Passport passport = null;
		if (StringUtils.isEmpty(passportStr)) {
			passport = new Passport();
		} else {
			passport = JSON.parseObject(passportStr, Passport.class);
		}
		return passport;
	}
}
