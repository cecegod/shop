package com.po;

public class Story {
    private Integer storyid;
    private String storyname;
    private Integer userid;
    private String time;

    @Override
    public String toString() {
        return "Story{" +
                "storyid=" + storyid +
                ", storyname='" + storyname + '\'' +
                ", userid=" + userid +
                ", time='" + time + '\'' +
                '}';
    }

    public Integer getStoryid() {
        return storyid;
    }

    public void setStoryid(Integer storyid) {
        this.storyid = storyid;
    }

    public String getStoryname() {
        return storyname;
    }

    public void setStoryname(String storyname) {
        this.storyname = storyname;
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

    public Story() {
    }

    public Story(Integer storyid, String storyname, Integer userid, String time) {
        this.storyid = storyid;
        this.storyname = storyname;
        this.userid = userid;
        this.time = time;
    }
}
