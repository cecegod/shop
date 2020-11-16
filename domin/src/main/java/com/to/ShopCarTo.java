package com.to;

public class ShopCarTo {
    private Integer id;
    private String productname;
    private Float price;
    private String productphotoname;
    private Integer number;
    private Integer stock;


    @Override
    public String toString() {
        return "ShopCarTo{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", price=" + price +
                ", productphotoname='" + productphotoname + '\'' +
                ", number=" + number +
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

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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

    public ShopCarTo() {
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ShopCarTo(Integer id, String productname, Float price, String productphotoname, Integer number, Integer stock) {
        this.id = id;
        this.productname = productname;
        this.price = price;
        this.productphotoname = productphotoname;
        this.number = number;
        this.stock = stock;
    }
}
