package com.service;

import com.mapper.MenuMapper;
import com.mapper.Role_MenuMapper;
import com.mapper.Role_UserMapper;
import com.po.Tb_menu;
import com.po.Tb_role_menu;
import com.po.Tb_user_role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {
    @Resource
    MenuMapper menuMapper;
    @Resource
    Role_UserMapper rum;
    @Resource
    Role_MenuMapper rmm;

    public Boolean addMenu(Tb_menu menu) {
        return menuMapper.addEntity(menu);
    }

    public Boolean deleteMenu(Integer id) {
        Tb_menu menu = new Tb_menu();
        menu.setId(id);
        return menuMapper.deleteEntity(menu);
    }

    public Tb_menu getMenu(Integer id) {
        Tb_menu menu = new Tb_menu();
        menu.setId(id);
        return menuMapper.getEntity(menu);

    }

    public Boolean updateMenu(Tb_menu menu, Integer id) {

        Tb_menu menu2 = new Tb_menu();
        menu2.setId(id);
        return  menuMapper.updateEntity(menu,menu2);
    }

    public List<Tb_menu> getMenus() {
        return menuMapper.getEntities(new Tb_menu());

    }

    public List<Tb_menu> getMenuByUser(Integer userid) {
        List<Tb_menu> list=new ArrayList<>();
        Tb_user_role tb_user_role = rum.getEntity(new Tb_user_role(null, userid, null));
        List<Tb_role_menu> tb_role_menus = rmm.getEntities(new Tb_role_menu(tb_user_role.getRole_id(), null));
        for(Tb_role_menu entity:tb_role_menus){
            Tb_menu tb_menu = new Tb_menu();
            tb_menu.setId(entity.getMenu_id());
            Tb_menu tbMenu = menuMapper.getEntity(tb_menu);
            list.add(tbMenu);
        }
        return list;
    }
}
