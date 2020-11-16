package com.to;

public class RPto {
    private Integer id;
    private String rolename;
    private String permissionname;

    @Override
    public String toString() {
        return "RPto{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", permissionname='" + permissionname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

    public RPto() {
    }

    public RPto(Integer id, String rolename, String permissionname) {
        this.id = id;
        this.rolename = rolename;
        this.permissionname = permissionname;
    }
}
