package com.po;

public class Tb_role_menu {
    private Integer role_id;
    private Integer menu_id;

    @Override
    public String toString() {
        return "Tb_role_menu{" +
                "role_id=" + role_id +
                ", menu_id=" + menu_id +
                '}';
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public Tb_role_menu() {
    }

    public Tb_role_menu(Integer role_id, Integer menu_id) {
        this.role_id = role_id;
        this.menu_id = menu_id;
    }
}
