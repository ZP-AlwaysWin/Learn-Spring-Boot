package com.example.springbootredis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {

    //StringRedisTemplate对象进行Redis的读写操作，该对象从命名中就可注意到支持的是String类型。
    // 如果有使用过spring-data-redis的开发者一定熟悉RedisTemplate<K, V>接口，
    // StringRedisTemplate就相当于RedisTemplate<String, String>的实现。
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void test() throws Exception {

        // 保存字符串
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));

    }
}
