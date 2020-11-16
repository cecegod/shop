package com.to;

public class OrderTo {
    private String ordernumber;
    private String adress;
    private String status;
    private Float totalprice;
    private String ordertime;
    private Integer number;

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public OrderTo(String ordernumber, String adress, String status, Float totalprice, String ordertime, Integer number) {
        this.ordernumber = ordernumber;
        this.adress = adress;
        this.status = status;
        this.totalprice = totalprice;
        this.ordertime = ordertime;
        this.number = number;
    }

    public OrderTo() {
    }
}
