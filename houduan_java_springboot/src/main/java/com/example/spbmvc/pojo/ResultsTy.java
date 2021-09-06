package com.example.spbmvc.pojo;

public class ResultsTy {
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getZx1() {
        return zx1;
    }

    @Override
    public String toString() {
        return "ResultsTy{" +
                "sno='" + sno + '\'' +
                ", zx1=" + zx1 +
                ", zx2=" + zx2 +
                ", tjq=" + tjq +
                ", xyp=" + xyp +
                ", pscj=" + pscj +
                ", zcj=" + zcj +
                ", resid=" + resid +
                ", tcid=" + tcid +
                '}';
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

    private String sno;//学号
    private Integer zx1;//专项1
    private Integer zx2;///专项2
    private Integer tjq;//太极拳
    private Integer xyp;//校园跑
    private Integer pscj;//平时成绩
    private Integer zcj;//总成绩
    private Integer resid;//成绩ID。。主键
    private Integer tcid;//班级ID

}
