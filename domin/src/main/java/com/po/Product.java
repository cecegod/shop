package com.po;

public class Product {
    private Integer id;
    private String productname;
    private Integer categoryid;
    private Float price;
    private  Integer userid;
    private String productphotoname;
    private Integer stock;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", categoryid=" + categoryid +
                ", price=" + price +
                ", userid=" + userid +
                ", productphotoname='" + productphotoname + '\'' +
                ", stock=" + stock +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Integer categoryid) {
        this.categoryid = categoryid;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getProductphotoname() {
        return productphotoname;
    }

    public void setProductphotoname(String productphotoname) {
        this.productphotoname = productphotoname;
    }

    public Product() {
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Product(Integer id, String productname, Integer categoryid, Float price, Integer userid, String productphotoname, Integer stock) {
        this.id = id;
        this.productname = productname;
        this.categoryid = categoryid;
        this.price = price;
        this.userid = userid;
        this.productphotoname = productphotoname;
        this.stock = stock;
    }
}
