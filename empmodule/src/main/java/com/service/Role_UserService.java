package com.service;

import com.mapper.RoleMapper;
import com.mapper.Role_UserMapper;
import com.po.Tb_role;
import com.po.Tb_user_role;
import com.po.User;
import com.to.RUto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class Role_UserService {
    @Resource
    Role_UserMapper rum;
    @Resource
    RoleMapper roleMapper;




    public List<RUto> getRole_Users() {
        List<RUto> list=new ArrayList<>();
        List<Tb_user_role> entities = rum.getEntities(new Tb_user_role());
        for(Tb_user_role entity:entities){
            Tb_role tb_role = new Tb_role();
            tb_role.setId(entity.getRole_id());
            Tb_role role = roleMapper.getEntity(tb_role);

            RestTemplate restTemplate=new RestTemplate();
            User user = restTemplate.getForObject("http:localhost:8080/getUser?id=" + entity.getUser_id(), User.class);


            RUto rUto = new RUto();
            rUto.setId(entity.getId());
            rUto.setRolename(role.getName());
            rUto.setUsername(user.getUsername());
            list.add(rUto);
        }
        return list;
    }

    public Boolean addRole_User(Tb_user_role ru) {
        return rum.addEntity(ru);
    }

    public Boolean deleteRole_User(Integer id) {
        Tb_user_role ru = new Tb_user_role();
        ru.setId(id);
        return rum.deleteEntity(ru);

    }

    public Tb_user_role getRole_User(Integer id) {
        Tb_user_role ru = new Tb_user_role();
        ru.setId(id);
        return rum.getEntity(ru);
    }

    public Boolean updateRole_User(Tb_user_role ru, Integer id) {
        Tb_user_role ru2 = new Tb_user_role();
        ru2.setId(id);
        return rum.updateEntity(ru,ru2);
    }
}
