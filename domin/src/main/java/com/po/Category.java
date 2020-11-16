package com.po;

public class Category {
    private Integer id;
    private Integer parentid;
    private String categoryname;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", parentid=" + parentid +
                ", categoryname='" + categoryname + '\'' +
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

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Category() {
    }

    public Category(Integer id, Integer parentid, String categoryname) {
        this.id = id;
        this.parentid = parentid;
        this.categoryname = categoryname;
    }
}
