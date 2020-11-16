package com.service;

import com.mapper.RoleMapper;
import com.po.Tb_role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleService {
    @Resource
    RoleMapper roleMapper;


    public Boolean addRole(Tb_role role) {
        return roleMapper.addEntity(role);
    }

    public Boolean deleteRole(Integer id) {
        Tb_role role = new Tb_role();
        role.setId(id);
        return roleMapper.deleteEntity(role);
    }

    public Tb_role getRole(Integer id) {
        Tb_role role = new Tb_role();
        role.setId(id);
        return roleMapper.getEntity(role);

    }

    public Boolean updateRole(Tb_role role, Integer id) {

        Tb_role role2 = new Tb_role();
        role2.setId(id);
        return  roleMapper.updateEntity(role,role2);
    }

    public List<Tb_role> getRoles() {
        return roleMapper.getEntities(new Tb_role());

    }
}
