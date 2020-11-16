package com.po;

public class Tb_role {
    private Integer id;
    private Integer parent_id;
    private  String name;
    private  String enname;
    private  String description;
    private String created;
    private String updated;

    @Override
    public String toString() {
        return "Tb_role{" +
                "id=" + id +
                ", parent_id=" + parent_id +
                ", name='" + name + '\'' +
                ", enname='" + enname + '\'' +
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

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
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

    public Tb_role() {
    }

    public Tb_role(Integer id, Integer parent_id, String name, String enname, String description, String created, String updated) {
        this.id = id;
        this.parent_id = parent_id;
        this.name = name;
        this.enname = enname;
        this.description = description;
        this.created = created;
        this.updated = updated;
    }
}
