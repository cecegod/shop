package com.po;


public class Ordertable {
    private String ordernumber;
    private  String status;
    private Integer addressid;
    private Float totalprice;
    private String ordertime;


    public Ordertable() {
    }

    @Override
    public String toString() {
        return "Ordertable{" +
                "ordernumber='" + ordernumber + '\'' +
                ", status='" + status + '\'' +
                ", addressid=" + addressid +
                ", totalprice=" + totalprice +
                ", ordertime='" + ordertime + '\'' +
                '}';
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    public Float getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Float totalprice) {
        this.totalprice = totalprice;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public Ordertable(String ordernumber, String status, Integer addressid, Float totalprice, String ordertime) {
        this.ordernumber = ordernumber;
        this.status = status;
        this.addressid = addressid;
        this.totalprice = totalprice;
        this.ordertime = ordertime;
    }
}
