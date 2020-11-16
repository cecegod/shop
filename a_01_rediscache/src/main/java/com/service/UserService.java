package com.service;

import com.mapper.UserMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    @Cacheable("a")
    public Map getMap(){
        return userMapper.getMap();
    }


    @CacheEvict("a")
    public void add() {

        userMapper.add();
    }
}
