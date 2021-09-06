package com.example.spbmvc.pojo;

public class TeacherClassTy {
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

    private Integer tcid;//班级ID

    @Override
    public String toString() {
        return "TeacherClassTy{" +
                "tcid=" + tcid +
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

    private Integer cid;//课程号
    private String cname;//课程名
    private String tname;//教师姓名
    private Integer tgh;//教师工号
    private Integer rsxz;//选课人数限制
    private String xq;//校区
    private String sqrade;//年级
    private String sksd;//选课时段（第几节课）
    private String sksq;//选课时区（周几）
    private String isend;//是否结课
    private String ssex;//课程性别限制
    private Integer xkrs;//当前选课人数
}
