package com.controller;

import com.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("/name1")
    public String  name1(String username) {
            return "name1";
    }

    @RequestMapping("/name2")
    public String name2(){
        return "name2";
    }

    @RequestMapping("/name3")
    public String name3(){
        return "name3";
    }
    @RequestMapping("/name4")
    public String name4(){
        return "name4";
    }
    @RequestMapping("/success")
    public  String success(){
        return "success";
    }

    @RequestMapping("/failure")
    public String failure(){
        return "failure";
    }


}

