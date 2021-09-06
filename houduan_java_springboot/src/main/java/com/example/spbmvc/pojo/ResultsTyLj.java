package com.example.spbmvc.pojo;

public class ResultsTyLj {
    private String sno;//学号
    private Integer zx1;//专项1
    private Integer zx2;///专项2
    private Integer tjq;//太极拳
    private Integer xyp;//校园跑
    private Integer pscj;//平时成绩

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getZx1() {
        return zx1;
    }

    public void setZx1(Integer zx1) {
        this.zx1 = zx1;
    }

    public Integer getZx2() {
        return zx2;
    }

    public void setZx2(Integer zx2) {
        this.zx2 = zx2;
    }

    public Integer getTjq() {
        return tjq;
    }

    public void setTjq(Integer tjq) {
        this.tjq = tjq;
    }

    public Integer getXyp() {
        return xyp;
    }

    public void setXyp(Integer xyp) {
        this.xyp = xyp;
    }

    public Integer getPscj() {
        return pscj;
    }

    public void setPscj(Integer pscj) {
        this.pscj = pscj;
    }

    public Integer getZcj() {
        return zcj;
    }

    public void setZcj(Integer zcj) {
        this.zcj = zcj;
    }

    public Integer getResid() {
        return resid;
    }

    public void setResid(Integer resid) {
        this.resid = resid;
    }

    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public String getSqrade() {
        return sqrade;
    }

    public void setSqrade(String sqrade) {
        this.sqrade = sqrade;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getSxy() {
        return sxy;
    }

    public void setSxy(String sxy) {
        this.sxy = sxy;
    }

    private Integer zcj;//总成绩
    private Integer resid;//成绩ID。。主键
    private Integer tcid;//班级ID
    private String sname;//学生姓名
    private String ssex;//学生性别
    private String sqrade;//年级
    private String sclass;//班级
    private String sxy;//教学院
}
