package com.eden.redis;

import redis.clients.jedis.Jedis;

public class RedisTest {
	
	
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		jedis.set("name", "wued");
		System.out.println(jedis.get("name"));
		System.out.println(jedis.get("aa"));
		
		jedis.close();
	}

}
