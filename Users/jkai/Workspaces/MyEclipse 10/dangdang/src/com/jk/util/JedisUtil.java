package com.jk.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	//对于重量级的资源只创建一次
	private static JedisPool jedisPool;
	static{
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		//设置最大空闲连接数
		jedisPoolConfig.setMinIdle(10);
		//设置最大连接数
		jedisPoolConfig.setMaxActive(50);
		//如果连接都被占用，通过这个值，设置最多等待的毫秒数
		jedisPoolConfig.setMaxWait(1500);
		//创建连接池
		jedisPool = new JedisPool(jedisPoolConfig,"192.168.137.131", 6379);
	}
	public static Jedis getJedis(){
		return jedisPool.getResource();
	}
	public static void close(Jedis jedis){
		if(jedis != null){
			jedis.quit();			
		}
	}
}
