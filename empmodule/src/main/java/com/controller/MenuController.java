package com.controller;

import com.po.Tb_menu;
import com.service.MenuService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@CrossOrigin
public class MenuController {
    @Resource
    MenuService menuService;

    @RequestMapping("/getMenus")
    public List<Tb_menu> getMenus(){
        return menuService.getMenus();
    }

    @RequestMapping("/addMenu")
    public Boolean addMenu(Tb_menu menu){
        return menuService.addMenu(menu);
    }

    @RequestMapping("/deleteMenu")
    public Boolean deleteMenu(Integer id){
        return menuService.deleteMenu(id);
    }
    @RequestMapping("/getMenu")
    public Tb_menu getmenu(Integer id){
        return menuService.getMenu(id);
    }
    @RequestMapping("/updateMenu")
    public Boolean updateMenu(Tb_menu menu,Integer id){
        return menuService.updateMenu(menu,id);
    }

    @RequestMapping("/getMenuByUser")
    public List<Tb_menu> getMenuByUser(Integer userid){
        List<Tb_menu> list= menuService.getMenuByUser(userid);
        return list;
    }
}
