package com.po;

public class Ordertabledetail {
    private String  id;
    private  Integer productid;
    private  Integer number;
    private  Integer userid;
    private String  time;
    private String status;
    private  String ordernumber;

    public Ordertabledetail(String id, Integer productid, Integer number, Integer userid, String time, String status, String ordernumber) {
        this.id = id;
        this.productid = productid;
        this.number = number;
        this.userid = userid;
        this.time = time;
        this.status = status;
        this.ordernumber = ordernumber;
    }

    public Ordertabledetail() {
    }

    @Override
    public String toString() {
        return "Ordertabledetail{" +
                "id='" + id + '\'' +
                ", productid=" + productid +
                ", number=" + number +
                ", userid=" + userid +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", ordernumber='" + ordernumber + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }
}
