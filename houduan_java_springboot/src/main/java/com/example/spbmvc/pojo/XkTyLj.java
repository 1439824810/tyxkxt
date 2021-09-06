package com.example.spbmvc.pojo;

public class XkTyLj {
    private Integer xkid;
    private String sno;
    private String sname;
    private Integer tcid;
    private Integer cid;
    private String cname;
    private String tname;
    private Integer tgh;

    public Integer getXkid() {
        return xkid;
    }

    public void setXkid(Integer xkid) {
        this.xkid = xkid;
    }

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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTgh() {
        return tgh;
    }

    public void setTgh(Integer tgh) {
        this.tgh = tgh;
    }

    public Integer getRsxz() {
        return rsxz;
    }

    public void setRsxz(Integer rsxz) {
        this.rsxz = rsxz;
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

    @Override
    public String toString() {
        return "XkTyLj{" +
                "xkid=" + xkid +
                ", sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", tcid=" + tcid +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", tname='" + tname + '\'' +
                ", tgh=" + tgh +
                ", rsxz=" + rsxz +
                ", xq='" + xq + '\'' +
                ", sqrade='" + sqrade + '\'' +
                ", sksd='" + sksd + '\'' +
                ", sksq='" + sksq + '\'' +
                ", isend='" + isend + '\'' +
                ", ssex='" + ssex + '\'' +
                ", xkrs=" + xkrs +
                '}';
    }

    public void setSqrade(String sqrade) {
        this.sqrade = sqrade;
    }

    public String getSksd() {
        return sksd;
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

    public String getIsend() {
        return isend;
    }

    public void setIsend(String isend) {
        this.isend = isend;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getXkrs() {
        return xkrs;
    }

    public void setXkrs(Integer xkrs) {
        this.xkrs = xkrs;
    }

    private Integer rsxz;
    private String xq;
    private String sqrade;
    private String sksd;
    private String sksq;
    private String isend;
    private String ssex;
    private Integer xkrs;

}
