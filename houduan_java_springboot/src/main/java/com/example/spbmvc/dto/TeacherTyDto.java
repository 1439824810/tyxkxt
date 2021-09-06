package com.example.spbmvc.dto;

public class TeacherTyDto {
    private Integer tgh;

    public Integer getTgh() {
        return tgh;
    }

    public void setTgh(Integer tgh) {
        this.tgh = tgh;
    }

    public String getTname() {
        return tname;
    }

    public String getRetired() {
        return retired;
    }

    public void setRetired(String retired) {
        this.retired = retired;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    private String tname;
    private String retired;

}
