package com.to;

public class CommentTo {
    private String username;
    private String photoname;
    private String comment;

    public CommentTo(String username, String photoname, String comment) {
        this.username = username;
        this.photoname = photoname;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentTo{" +
                "username='" + username + '\'' +
                ", photoname='" + photoname + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhotoname() {
        return photoname;
    }

    public void setPhotoname(String photoname) {
        this.photoname = photoname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentTo() {
    }
}
