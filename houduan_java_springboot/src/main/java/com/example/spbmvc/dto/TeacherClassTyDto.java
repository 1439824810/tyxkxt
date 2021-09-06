package com.example.spbmvc.dto;

public class TeacherClassTyDto {
    private String tname;
    private String cname;
    private String xq;
    private String sqrade;

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getXq() {
        return xq;
    }

    public void setXq(String xq) {
        this.xq = xq;
    }

    public String getSqrade() {
        return sqrade;
    }

    public void setSqrade(String sqrade) {
        this.sqrade = sqrade;
    }

    public String getSksd() {
        return sksd;
    }

    @Override
    public String toString() {
        return "TeacherClassTyDto{" +
                "tname='" + tname + '\'' +
                ", cname='" + cname + '\'' +
                ", xq='" + xq + '\'' +
                ", sqrade='" + sqrade + '\'' +
                ", sksd='" + sksd + '\'' +
                ", sksq='" + sksq + '\'' +
                '}';
    }

    public void setSksd(String sksd) {
        this.sksd = sksd;
    }

    public String getSksq() {
        return sksq;
    }

    public void setSksq(String sksq) {
        this.sksq = sksq;
    }

    private String sksd;
    private String sksq;
}
