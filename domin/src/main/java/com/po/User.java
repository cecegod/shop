package com.po;

public class User {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private String email;
    private String grade;
    private String photoname;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", grade='" + grade + '\'' +
                ", photoname='" + photoname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    public User() {
    }

    public User(Integer id, String username, String password, String sex, String email, String grade, String photoname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.grade = grade;
        this.photoname = photoname;
    }
}
