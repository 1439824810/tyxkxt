package com.example.spbmvc.pojo;

public class ClassTy {
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

    public String getCscope() {
        return cscope;
    }

    @Override
    public String toString() {
        return "ClassTy{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cscope='" + cscope + '\'' +
                ", cinfo='" + cinfo + '\'' +
                ", islife='" + islife + '\'' +
                '}';
    }

    public void setCscope(String cscope) {
        this.cscope = cscope;
    }

    public String getCinfo() {
        return cinfo;
    }

    public void setCinfo(String cinfo) {
        this.cinfo = cinfo;
    }

    public String getIslife() {
        return islife;
    }

    public void setIslife(String islife) {
        this.islife = islife;
    }

    private Integer cid;//课程号
    private String cname;//课程名
    private String cscope;//授课范围
    private String cinfo;//课程简介
    private String islife="1";//是否开课

}
