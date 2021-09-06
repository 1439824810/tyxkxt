package com.example.spbmvc.pojo;

public class StuTeacherClassTyLj {
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    public String getSksq() {
        return sksq;
    }

    public void setSksq(String sksq) {
        this.sksq = sksq;
    }

    public String getSksd() {
        return sksd;
    }

    public void setSksd(String sksd) {
        this.sksd = sksd;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "StuTeacherClassTyLj{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", tcid=" + tcid +
                ", sksq='" + sksq + '\'' +
                ", sksd='" + sksd + '\'' +
                ", tname='" + tname + '\'' +
                '}';
    }

    String sno;
    String sname;
    Integer tcid;
    String sksq;
    String sksd;
    String tname;
}
