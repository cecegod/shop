package com.controller;

import com.po.Tb_user_role;
import com.service.Role_UserService;
import com.to.RUto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class Role_UserController {
    @Resource
    Role_UserService rus;
    @RequestMapping("/getRole_Users")
    public List<RUto> getRole_Users(){
        return rus.getRole_Users();
    }
    @RequestMapping("/addRole_User")
    public Boolean addRole_User(Tb_user_role rp){
        return rus.addRole_User(rp);
    }
    @RequestMapping("/deleteRole_User")
    public Boolean deleteRole_User(Integer id){
        return rus.deleteRole_User(id);
    }
    @RequestMapping("/getRole_User")
    public Tb_user_role getRole_User(Integer id){
        return rus.getRole_User(id);
    }
    @RequestMapping("/updateRole_User")
    public Boolean updateRole_User(Integer id,Integer role_id ,Integer user_id){
        Tb_user_role rp = new Tb_user_role();
        rp.setUser_id(user_id);
        rp.setRole_id(role_id);
        return rus.updateRole_User(rp,id);
    }
    
}
