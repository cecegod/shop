package com.controller;

import com.po.User;
import com.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/register")
    public Map register(User user, @RequestParam("file") MultipartFile file, HttpServletRequest request){
        Map map=new HashMap();


        Boolean register=userService.register(user,file,request);
        if(register){
            map.put("status",200);
        }
        else{
            map.put("status",500);
        }
        return  map;
    }
    @RequestMapping("/login")
    public Map Login(String username,String password){
        Map map=new HashMap();
        String  [] status = new String [1];
        User user=userService.login(username,password,status);

        if(user!=null){
            map.put("user",user);
            map.put("status",200);
            map.put("loginstatus",status[0]);
        }else {
            map.put("status",200);
            map.put("loginstatus",status[0]);
        }
        return  map;
    }


    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, String chunk) {
        if (file.isEmpty()) {
            return "上传失败，请选择文件";
        }
        String fileName = file.getOriginalFilename();
        String filePath = this.getClass().getResource("/").getPath();
        new File(filePath + "static").mkdirs();

        File dest = new File(filePath + "static/"+fileName);
        System.out.println(dest.getPath());
        try {
            file.transferTo(dest);
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/getUser")
    public User getUser(Integer id){
        return userService.getUser(id);
    }

    @RequestMapping("/loadMyfollow")
    public Map loadMyfollow(Integer userId){
        RestTemplate restTemplate = new RestTemplate();
        Map followTos = restTemplate.getForObject("http://localhost:8081/collectProduct?userId=" + userId, Map.class);
        return followTos;
    }

    @RequestMapping("/getordertables")
    public Map getordertables(Integer userid){
        RestTemplate restTemplate = new RestTemplate();
        Map map = restTemplate.getForObject("http://localhost:8082/getordertables?userid=" + userid, Map.class);
        return map;
    }
    @RequestMapping("/getordertabledetails")
    public Map getordertabledetails(Integer userid,String ordernumber){
        RestTemplate restTemplate = new RestTemplate();
        Map map = restTemplate.getForObject("http://localhost:8082/getordertabledetails?userid=" + userid+"&ordernumber="+ordernumber, Map.class);
        return map;
    }
    @RequestMapping("/getUsers")
    public Map getUsers(){

        List<User> users = userService.getUsers();
        Map map=new HashMap();
        map.put("users",users);
        return map;

    }
}
