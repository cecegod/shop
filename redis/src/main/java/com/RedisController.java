package com;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RedisController {
    @Resource
    RedisTemplate redisTemplate;
    @RequestMapping("/setKeyValue")
    public void setKeyValue(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name","zhangsan");
    }

    @RequestMapping("/getValue")
    public Object getValue(){
        ValueOperations valueOperations = redisTemplate.opsForValue();
         return valueOperations.get("name");
    }

    @RequestMapping("/hset")
    public void hset(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("user","name","zhangsan");
        hashOperations.put("user","id","1");
        hashOperations.put("user","password","123456");
    }
    @RequestMapping("hget")
    public String hget(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        Object id = hashOperations.get("user","id");
        Object username =  hashOperations.get("user","username");
        Object password =  hashOperations.get("user","password");
        return  id+"  "+username+"  "+password;
    }
    @RequestMapping("/lpush")
    public void lpush(){
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.leftPushAll("names","zhangsa","lisi","wangwu");
    }


    @RequestMapping("/rpush")
    public void rpush(){
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.rightPushAll("names","zhangsa","lisi","wangwu");
    }

    @RequestMapping("/range")
    public Object range(){
        ListOperations listOperations = redisTemplate.opsForList();
        List names = listOperations.range("names", 0, -1);
        return  names;
    }
}
