package com.heima.test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;
public class JedisTest {
    private Jedis jedis;

    // 建立链接
    @BeforeEach
    void setUp(){
        jedis = new Jedis("127.0.0.1", 6379);
        jedis.select(0);
    }

    @Test
    void testString(){
        String result = jedis.set("name", "yan");
        System.out.println(result);

        String name = jedis.get("name");
        System.out.println(name);
    }

    @AfterEach
    void tearDown(){
        if(jedis != null){
            jedis.close();
        }
    }
}
