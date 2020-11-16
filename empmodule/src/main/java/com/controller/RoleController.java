package com.controller;

import com.po.Tb_role;
import com.service.RoleService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class RoleController {
    @Resource
    RoleService roleService;

    @RequestMapping("/getRoles")
    public List<Tb_role> getRoles(){
        return roleService.getRoles();
    }

    @RequestMapping("/addRole")
    public Boolean addRole(Tb_role role){
        return roleService.addRole(role);
    }

    @RequestMapping("/deleteRole")
    public Boolean deleteRole(Integer id){
        return roleService.deleteRole(id);
    }
    @RequestMapping("/getRole")
    public Tb_role getRole(Integer id){
        return roleService.getRole(id);
    }
    @RequestMapping("/updateRole")
    public Boolean updateRole(Tb_role role,Integer id){
        return roleService.updateRole(role,id);
    }


}
