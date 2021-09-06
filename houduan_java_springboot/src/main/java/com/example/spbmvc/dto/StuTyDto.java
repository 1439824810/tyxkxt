package com.example.spbmvc.dto;

public class StuTyDto {
//    @Param("sname")String sname,@Param("sno")String sno,@Param("sxy")String sxy,@Param("sqrade")String sqrade
    private String sname;
    private String sno;

    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    private Integer tcid;

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSxy() {
        return sxy;
    }

    public void setSxy(String sxy) {
        this.sxy = sxy;
    }

    public String getSqrade() {
        return sqrade;
    }

    public void setSqrade(String sqrade) {
        this.sqrade = sqrade;
    }

    private String sxy;
    private String sqrade;
}
