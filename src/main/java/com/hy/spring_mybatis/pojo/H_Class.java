package com.hy.spring_mybatis.pojo;


import java.util.List;

public class H_Class {
    private Integer cid;
    private String cname;
    private String clx;
    private List<H_Student> stu;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getClx() {
        return clx;
    }

    public void setClx(String clx) {
        this.clx = clx;
    }

    public List<H_Student> getStu() {
        return stu;
    }

    public void setStu(List<H_Student> stu) {
        this.stu = stu;
    }

    @Override
    public String toString() {
        return "H_Class{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", clx='" + clx + '\'' +
                ", stu=" + stu +
                '}';
    }
}