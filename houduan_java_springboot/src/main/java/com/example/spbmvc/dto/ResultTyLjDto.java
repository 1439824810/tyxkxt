package com.example.spbmvc.dto;

public class ResultTyLjDto {
    private String sno;

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public Integer getTcid() {
        return tcid;
    }

    @Override
    public String toString() {
        return "ResultTyLjDto{" +
                "sno='" + sno + '\'' +
                ", tcid=" + tcid +
                '}';
    }

    public void setTcid(Integer tcid) {
        this.tcid = tcid;
    }

    private Integer tcid;
}
