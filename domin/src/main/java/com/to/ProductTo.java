package com.to;

public class ProductTo {
    private Integer id;
    private String productname;
    private String categoryname;
    private Float price;
    private String productphotoname;
    private Integer stock;


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

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
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

    public ProductTo() {
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public ProductTo(Integer id, String productname, String categoryname, Float price, String productphotoname, Integer stock) {
        this.id = id;
        this.productname = productname;
        this.categoryname = categoryname;
        this.price = price;
        this.productphotoname = productphotoname;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ProductTo{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", categoryname='" + categoryname + '\'' +
                ", price=" + price +
                ", productphotoname='" + productphotoname + '\'' +
                ", stock=" + stock +
                '}';
    }
}
