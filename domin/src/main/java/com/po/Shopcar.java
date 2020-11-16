package com.po;

public class Shopcar {
    private Integer id;
    private Integer productid;
    private Integer number;
    private Integer userid;

    @Override
    public String toString() {
        return "Shopcar{" +
                "id=" + id +
                ", productid=" + productid +
                ", number=" + number +
                ", userid=" + userid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Shopcar() {
    }

    public Shopcar(Integer id, Integer productid, Integer number, Integer userid) {
        this.id = id;
        this.productid = productid;
        this.number = number;
        this.userid = userid;
    }
}
