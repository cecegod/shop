package com.controller;

import com.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserService userService;
    @RequestMapping("/name1")
    public String  name1() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return "用户名："+principal.toString();

    }

    @RequestMapping("/name2")
    public String name2(){
        return "name2";
    }

    @RequestMapping("/name3")
    public String name3(){
        return "name3";
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

