package com.example.spbmvc.pojo;

public class XkTy {
    private Integer xkid;//选课标识号

    public Integer getXkid() {
        return xkid;
    }

    public void setXkid(Integer xkid) {
        this.xkid = xkid;
    }

    public Integer getTcid() {
        return tcid;
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    public String getSno() {
        return sno;
    }

    @Override
    public String toString() {
        return "XkTy{" +
                "xkid=" + xkid +
                ", tcid=" + tcid +
                ", sno='" + sno + '\'' +
                '}';
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    private Integer tcid;//班级id
    private String sno;//学号
}
