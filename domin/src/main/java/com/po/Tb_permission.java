package com.po;

public class Tb_permission {
    private Integer id;
    private  Integer parent_id;
    private String name;
    private String enname;
    private  String url;
    private String description;
    private String created;
    private String updated;

    @Override
    public String toString() {
        return "Tb_permission{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", name='" + name + '\'' +
                ", enname='" + enname + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getenname() {
        return enname;
    }

    public void setenname(String enname) {
        this.enname = enname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public Tb_permission() {
    }

    public Tb_permission(Integer id, Integer parent_id, String name, String enname, String url, String description, String created, String updated) {
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
        this.enname = enname;
        this.url = url;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }
}
