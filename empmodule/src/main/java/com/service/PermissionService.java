package com.service;

import com.mapper.PermissionMapper;
import com.mapper.RoleMapper;
import com.po.Tb_permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PermissionService {
    @Resource
    PermissionMapper permissionMapper;
    @Resource
    RoleMapper roleMapper;

    public List<Tb_permission> getPermissionByparent() {
        return permissionMapper.getPermissionByparent();
    }

    public List<Tb_permission> getPermissionBychild(Integer parentid) {
        return permissionMapper.getPermissionBychild(parentid);

    }


    public Boolean addPermission(Tb_permission permission) {

        return permissionMapper.addEntity(permission);
    }

    public Boolean deletePermission(Integer id) {
        Tb_permission permission = new Tb_permission();
        permission.setId(id);
        return permissionMapper.deleteEntity(permission);

    }

    public Tb_permission getPermission(Integer id) {
        Tb_permission permission = new Tb_permission();
        permission.setId(id);
        return permissionMapper.getEntity(permission);
    }

    public Boolean updatePermission(Tb_permission permission,Integer id) {
        Tb_permission permission2 = new Tb_permission();
        permission2.setId(id);
        return  permissionMapper.updateEntity(permission,permission2);

    }


    public List<Tb_permission> getPermissions() {
        return permissionMapper.getEntities(new Tb_permission());
    }
}
