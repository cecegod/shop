package com.service;

import com.mapper.UserMapper;
import com.po.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Resource
    UserMapper userMapper;

    public Boolean register(User user, MultipartFile file, HttpServletRequest request) {
        String contextPath = request.getContextPath();
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String basepath=scheme+"://"+serverName+":"+serverPort+contextPath+"/";

        String fileName = file.getOriginalFilename();
        String pnamesufix=fileName.substring(fileName.lastIndexOf("."));
        long time = new Date().getTime();
        String pnameprefix=user.getUsername()+"_"+time;
        String pname=pnameprefix+pnamesufix;

        String photoname=basepath+pname;
        user.setPhotoname(photoname);
        String filePath = this.getClass().getResource("/").getPath();
        new File(filePath + "static").mkdirs();

        File dest = new File(filePath + "static/"+pname);
        try {
           file.transferTo(dest);
            System.out.println("上传成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Boolean aBoolean = userMapper.addEntity(user);
        return aBoolean;

    }


    public User login(String username, String password, String[] status) {

        User entity = userMapper.getEntity(new User(null, username, null, null, null, null, null));

        if(entity!=null){
            if(entity.getPassword().equals(password)){
                status[0]="success";
                return entity;
            }else {
                status[0]="密码错误";
                return null;
            }
        }else {
            status[0]="用户名不存在";
            return null;
        }
    }

    public User getUser(Integer id) {

        return userMapper.getEntity(new User(id,null,null,null,null,null,null));
    }

    public List<User> getUsers() {
        return userMapper.getEntities(new User());

    }
}
