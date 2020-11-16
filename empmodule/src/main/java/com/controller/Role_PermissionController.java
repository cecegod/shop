package com.controller;

import com.po.Tb_role_permission;
import com.service.Role_PermissionService;
import com.to.RPto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class Role_PermissionController {
    @Resource
    Role_PermissionService rps;

    @RequestMapping("/getRole_Permissions")
    public List<RPto> getRole_Permissions(){
        return rps.getRole_Permissions();
    }
    @RequestMapping("/addRole_Permission")
    public Boolean addRole_Permission(Tb_role_permission rp){
        return rps.addRole_Permission(rp);
    }
    @RequestMapping("/deleteRole_Permission")
    public Boolean deleteRole_Permission(Integer id){
        return rps.deleteRole_Permission(id);
    }
    @RequestMapping("/getRole_Permission")
    public Tb_role_permission getRole_Permission(Integer id){
        return rps.getRole_Permission(id);
    }
    @RequestMapping("/updateRole_Permission")
    public Boolean updateRole_Permission(Integer id,Integer role_id ,Integer permission_id){
        Tb_role_permission rp = new Tb_role_permission();
        rp.setPermission_id(permission_id);
        rp.setRole_id(role_id);
        return rps.updateRole_Permission(rp,id);
    }
}
