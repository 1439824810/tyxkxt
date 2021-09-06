package com.example.spbmvc.pojo;

public class TeacherTy {
    public Integer getTgh() {
        return tgh;
    }

    public void setTgh(Integer tgh) {
        this.tgh = tgh;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTinfo() {
        return tinfo;
    }

    public void setTinfo(String tinfo) {
        this.tinfo = tinfo;
    }

    public String getTdept() {
        return tdept;
    }

    public void setTdept(String tdept) {
        this.tdept = tdept;
    }

    public String getRetired() {
        return retired;
    }

    public void setRetired(String retired) {
            this.retired = retired;
    }

    private Integer tgh;//教师工号
    private String tname;//教师姓名
    private String tsex;//教师性别
    private String tinfo;//教师信息
    private String tdept;//教师所在部门
    private String retired="1";//是否退休
}
