package com.po;

public class Follow {
    private Integer id;
    private  Integer userid;
    private  Integer productid;

    @Override
    public String toString() {
        return "Follow{" +
                "id=" + id +
                ", userid=" + userid +
                ", productid=" + productid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Follow() {
    }

    public Follow(Integer id, Integer userid, Integer productid) {
        this.id = id;
        this.userid = userid;
        this.productid = productid;
    }
}
