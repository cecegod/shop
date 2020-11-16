package com.to;

public class OrderdetailDTO {
    private String id;
    private String productname;
    private Integer userid;
    private Float totalprice;
    private String productphotoname;
    private Integer number;
    private String  time;
    private String status;
    private String address;

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", productname=" + productname +
                ", userid=" + userid +
                ", totalprice=" + totalprice +
                ", productphotoname='" + productphotoname + '\'' +
                ", number=" + number +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice = totalprice;
    }

    public String getProductphotoname() {
        return productphotoname;
    }

    public void setProductphotoname(String productphotoname) {
        this.productphotoname = productphotoname;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public OrderdetailDTO() {
    }

    public OrderdetailDTO(String  id, String productname, Integer userid, Float totalprice, String productphotoname, Integer number, String time, String status, String address) {
        this.id = id;
        this.productname = productname;
        this.userid = userid;
        this.totalprice = totalprice;
        this.productphotoname = productphotoname;
        this.number = number;
        this.time = time;
        this.status = status;
        this.address = address;
    }
}
