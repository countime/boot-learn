package com.countime.bootlearn.HelloWordController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/redistest/set", method = RequestMethod.GET)
    public String set() {
        redisTemplate.opsForValue().set("key1", "value1");
        return "set key1 success";
    }

    @RequestMapping(value = "/redistest/get", method = RequestMethod.GET)
    public String get() {
        String value1 = redisTemplate.opsForValue().get("key1");
        if(value1==null){
            return "查不到该key1";
        }
        return "get key1的结果:" + value1;
    }
}
