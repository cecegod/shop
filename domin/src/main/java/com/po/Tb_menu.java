package com.po;

public class Tb_menu {
    private Integer id;
    private Integer parentid;
    private String menuname;
    private String link;
    private Integer createuserid;

    @Override
    public String toString() {
        return "Tb_menu{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", menuname='" + menuname + '\'' +
                ", link='" + link + '\'' +
                ", createuserid=" + createuserid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(Integer createuserid) {
        this.createuserid = createuserid;
    }

    public Tb_menu() {
    }

    public Tb_menu(Integer id, Integer parentid, String menuname, String link, Integer createuserid) {
        this.id = id;
        this.parentid = parentid;
        this.menuname = menuname;
        this.link = link;
        this.createuserid = createuserid;
    }
}
