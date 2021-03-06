package com.po;

public class Comment {
    private Integer id;
    private Integer productid;
    private Integer userid;
    private String content;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", productid=" + productid +
                ", userid=" + userid +
                ", content='" + content + '\'' +
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

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comment() {
    }

    public Comment(Integer id, Integer productid, Integer userid, String content) {
        this.id = id;
        this.productid = productid;
        this.userid = userid;
        this.content = content;
    }
}
