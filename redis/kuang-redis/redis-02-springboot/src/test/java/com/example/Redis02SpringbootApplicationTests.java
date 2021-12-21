package com.example;

import com.example.pojo.User;
import com.example.utils.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    // 这就是之前 RedisAutoConfiguration 源码中的 Bean
    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test1(){
        redisUtil.set("name","小妹");
        System.out.println(redisUtil.get("name"));
    }

    @Test
    void contextLoads() {
        /** redisTemplate 操作不同的数据类型，API 和 Redis 中的是一样的
         * opsForValue 类似于 Redis 中的 String
         * opsForList 类似于 Redis 中的 List
         * opsForSet 类似于 Redis 中的 Set
         * opsForHash 类似于 Redis 中的 Hash
         * opsForZSet 类似于 Redis 中的 ZSet
         * opsForGeo 类似于 Redis 中的 Geospatial
         * opsForHyperLogLog 类似于 Redis 中的 HyperLogLog
         */

        // 除了基本的操作，常用的命令都可以直接通过redisTemplate.xxxx操作，比如事务、基本的CRUD……

        // 和数据库相关的操作都需要通过连接操作
        //获取Redis的连接对象
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        //connection.flushDb();

        redisTemplate.opsForValue().set("key", "needle");
        System.out.println(redisTemplate.opsForValue().get("key"));
    }

    @Test
    public void test() throws JsonProcessingException {
        //真实的开发一般都使用json来传递对象
        User user = new User("needle小妹", 2);
//        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }


}
