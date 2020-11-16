package com.to;

public class RUto {
    private Integer id;
    private String rolename;
    private String username;

    @Override
    public String toString() {
        return "RUto{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", username='" + username + '\'' +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RUto() {
    }

    public RUto(Integer id, String rolename, String username) {
        this.id = id;
        this.rolename = rolename;
        this.username = username;
    }
}
