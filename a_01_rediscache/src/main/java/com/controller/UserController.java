package com.controller;

import com.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/getMap")
    public Map getMap(){
         return userService.getMap();
    }
    @RequestMapping("/add")
    public void add(){
        userService.add();
    }
}
