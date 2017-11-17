package com.jk.util;

import java.io.Serializable;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.ibatis.cache.Cache;


public class RedisCache implements Cache{
	//id用于集成mybatis的日志
	private String id;
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	public String getId() {
		return id;
	}
	public RedisCache(String id) {
		super();
		this.id = id;
	}

	@Override
	public int getSize() {
		Long db = JedisUtil.getJedis().dbSize();
		return db.intValue();
	}

	@Override
	//需要引入commons-lang3包，使用SerializationUtils工具类序列化、反序列化
	public void putObject(Object key, Object value) {
		JedisUtil.getJedis().set(SerializationUtils.serialize((Serializable)key), SerializationUtils.serialize((Serializable)value));	
	}

	@Override
	//获得byte数据后，再反序列化为Object返回
	public Object getObject(Object key) {
		byte[] bs = JedisUtil.getJedis().get(SerializationUtils.serialize((Serializable)key));
		if(bs == null){
			return null;
		}
		return SerializationUtils.deserialize(bs);
	}

	@Override
	public Object removeObject(Object key) {
		byte[] bs = JedisUtil.getJedis().get(SerializationUtils.serialize((Serializable)key));
		JedisUtil.getJedis().del(SerializationUtils.serialize((Serializable)key));
		return SerializationUtils.deserialize(bs);
	}

	@Override
	public void clear() {
		JedisUtil.getJedis().flushDB();
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
	  
}
