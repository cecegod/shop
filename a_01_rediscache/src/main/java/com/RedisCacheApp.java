package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.mapper")
//启用缓存
@EnableCaching
public class RedisCacheApp {

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApp.class);
    }
}
