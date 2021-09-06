package com.example.spbmvc.dto;

import com.example.spbmvc.pojo.UsersTy;

public class UserTyQxDto{
    private Integer currentTgh;
    private String tname;//教师姓名
    private String pwd;//密码
    private Integer jurisdiction;//权限

    public Integer getCurrentTgh() {
        return currentTgh;
    }

    public void setCurrentTgh(Integer currentTgh) {
        this.currentTgh = currentTgh;
    }

    @Override
    public String toString() {
        return "UserTyQxDto{" +
                "currentTgh='" + currentTgh + '\'' +
                ", tname='" + tname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", jurisdiction=" + jurisdiction +
                ", tgh=" + tgh +
                '}';

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

    public void setJurisdiction(Integer jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public Integer getTgh() {
        return tgh;
    }

    public void setTgh(Integer tgh) {
        this.tgh = tgh;
    }

    private Integer tgh;//教师工号（为账号）
}
