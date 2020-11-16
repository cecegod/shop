package com.po;

public class Address {
    private Integer id;
    private String address;
    private Integer userid;
    private Boolean isdefault;

    public Address() {
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", userid=" + userid +
                ", isdefault=" + isdefault +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getIsdefault() {
        return isdefault;
    }

    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    public Address(Integer id, String address, Integer userid, Boolean isdefault) {
        this.id = id;
        this.address = address;
        this.userid = userid;
        this.isdefault = isdefault;
    }
}
