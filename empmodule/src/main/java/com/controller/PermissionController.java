package com.controller;

import com.po.Tb_permission;
import com.service.PermissionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class PermissionController {
    @Resource
    PermissionService permissionService;

    @RequestMapping("/getPermissionByparent")
    public  List<Tb_permission> getPermissionByparent(){
       List<Tb_permission> list= permissionService.getPermissionByparent();

       return list;

    }
    @RequestMapping("/getPermissionBychild")
    public List<Tb_permission> getPermissionBychild(Integer parentid){
        List<Tb_permission> list= permissionService.getPermissionBychild(parentid);

        return list;
    }
    @RequestMapping("/getPermissions")
    public List<Tb_permission> getPermissions(){
        return permissionService.getPermissions();
    }

    @RequestMapping("/addPermission")
    public Boolean addPermission(Tb_permission permission){
        return permissionService.addPermission(permission);
    }

    @RequestMapping("/deletePermission")
    public Boolean deletePermission(Integer id){
        return permissionService.deletePermission(id);
    }
    @RequestMapping("/getPermission")
    public Tb_permission getPermission(Integer id){
        return permissionService.getPermission(id);
    }
    @RequestMapping("/updatePermission")
    public Boolean updatePermission(Tb_permission permission,Integer id){
        return permissionService.updatePermission(permission,id);
    }


}
