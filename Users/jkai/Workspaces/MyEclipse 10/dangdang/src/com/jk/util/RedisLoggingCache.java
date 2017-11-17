package com.jk.util;

import org.apache.ibatis.cache.decorators.LoggingCache;

//为了实现日志功能，需要继承LoggingCache，在RedisCache的基础上包一层
public class RedisLoggingCache extends LoggingCache{
	public RedisLoggingCache(String id) {
		super(new RedisCache(id));	
	}
}
