package com.example.spbmvc.pojo;

public class UsersTy {
    private Integer tgh;//教师工号（为账号）

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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getJurisdiction() {
        return jurisdiction;
    }

    @Override
    public String toString() {
        return "UsersTy{" +
                "tgh=" + tgh +
                ", tname='" + tname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", jurisdiction=" + jurisdiction +
                '}';
    }

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    private String tname;//教师姓名
    private String pwd;//密码
    private Integer jurisdiction;//权限
}
