package com.fm.db;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * @author footmanff on 2017/11/24.
 */
public class RedisTest {

    /**
     *   spring.redis.host=192.168.16.250
         spring.redis.password=admin
         spring.redis.port=6379
         spring.redis.timeout=6000
         spring.redis.pool.max-active=300
         spring.redis.pool.max-idle=100
         spring.redis.pool.max-wait=1000
     * @param args
     */
    /*
        spring.redis.cluster.max-redirects= # Maximum number of redirects to follow when executing commands across the cluster.
        spring.redis.cluster.nodes= # Comma-separated list of "host:port" pairs to bootstrap from.
        spring.redis.database=0 # Database index used by the connection factory.
        spring.redis.url= # Connection URL, will override host, port and password (user will be ignored), e.g. redis://user:password@example.com:6379
        spring.redis.host=localhost # Redis server host.
        spring.redis.password= # Login password of the redis server.
        spring.redis.ssl=false # Enable SSL support.
        spring.redis.pool.max-active=8 # Max number of connections that can be allocated by the pool at a given time. Use a negative value for no limit.
        spring.redis.pool.max-idle=8 # Max number of "idle" connections in the pool. Use a negative value to indicate an unlimited number of idle connections.
        spring.redis.pool.max-wait=-1 # Maximum amount of time (in milliseconds) a connection allocation should block before throwing an exception when the pool is exhausted. Use a negative value to block indefinitely.
        spring.redis.pool.min-idle=0 # Target for the minimum number of idle connections to maintain in the pool. This setting only has an effect if it is positive.
        spring.redis.port=6379 # Redis server port.
        spring.redis.sentinel.master= # Name of Redis server.
        spring.redis.sentinel.nodes= # Comma-separated list of host:port pairs.
        spring.redis.timeout=0 # Connection timeout in milliseconds.
     */

    public static void main(String[] args) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(300);
        config.setMaxIdle(100);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);
        config.setTestOnReturn(true);
        JedisPool pool = new JedisPool(config, "192.168.16.250", 6379, 6000, "admin");
        
        Jedis jedis = null;
        try {
            jedis = pool.getResource();

            String set = jedis.set("somekey1", "value", "NX", "PX", 30000);
            String r = jedis.get("somekey");
            
            /// ... do stuff here ... for example
            jedis.set("foo", "bar");
            String foobar = jedis.get("foo");
            jedis.zadd("sose", 0, "car");
            jedis.zadd("sose", 0, "bike");
            Set<String> sose = jedis.zrange("sose", 0, -1);
        } finally {
            // You have to close jedis object. If you don't close then
            // it doesn't release back to pool and you can't get a new
            // resource from pool.
            if (jedis != null) {
                jedis.close();
            }
        }
        
        
        /// ... when closing your application:
        pool.destroy();
    }

}
