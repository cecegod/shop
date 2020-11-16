package com.service;

import com.mapper.PermissionMapper;
import com.mapper.RoleMapper;
import com.mapper.Role_PermissionMapper;
import com.po.Tb_permission;
import com.po.Tb_role;
import com.po.Tb_role_permission;
import com.to.RPto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class Role_PermissionService {
    @Resource
    Role_PermissionMapper rpm;
    @Resource
    PermissionMapper permissionMapper;
    @Resource
    RoleMapper roleMapper;


    public List<RPto> getRole_Permissions() {
        List<RPto> list=new ArrayList<>();
        List<Tb_role_permission> entities = rpm.getEntities(new Tb_role_permission());
        for(Tb_role_permission entity:entities){
            Tb_role tb_role = new Tb_role();
            tb_role.setId(entity.getRole_id());
            Tb_role role = roleMapper.getEntity(tb_role);

            Tb_permission tb_permission = new Tb_permission();
            tb_permission.setId(entity.getPermission_id());
            Tb_permission permission = permissionMapper.getEntity(tb_permission);

            RPto rPto = new RPto();
            rPto.setId(entity.getId());
            rPto.setPermissionname(permission.getName());
            rPto.setRolename(role.getName());
            list.add(rPto);
        }
        return list;
    }

    public Boolean addRole_Permission(Tb_role_permission rp) {
        return rpm.addEntity(rp);

    }

    public Boolean deleteRole_Permission(Integer id) {
        Tb_role_permission rp = new Tb_role_permission();
        rp.setId(id);
       return rpm.deleteEntity(rp);

    }

    public Tb_role_permission getRole_Permission(Integer id) {
        Tb_role_permission tb_role_permission = new Tb_role_permission();
        tb_role_permission.setId(id);
        Tb_role_permission entity = rpm.getEntity(tb_role_permission);
//
//        Tb_role tb_role = new Tb_role();
//        tb_role.setId(entity.getRole_id());
//        Tb_role role = roleMapper.getEntity(tb_role);
//
//        Tb_permission tb_permission = new Tb_permission();
//        tb_permission.setId(entity.getPermission_id());
//        Tb_permission permission = permissionMapper.getEntity(tb_permission);
//
//        RPto rPto = new RPto();
//        rPto.setPermissionname(permission.getName());
//        rPto.setRolename(role.getName());
        return entity;
    }

    public Boolean updateRole_Permission(Tb_role_permission rp, Integer id) {
        Tb_role_permission rp2 = new Tb_role_permission();
        rp2.setId(id);
        return rpm.updateEntity(rp,rp2);

    }
}
