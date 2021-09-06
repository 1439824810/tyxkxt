package com.example.spbmvc.pojo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;

import java.io.Serializable;

@ExcelTarget("stus")
public class StuTy extends BaseRowModel {

    @Excel(name = "学号")
    @ExcelProperty(value="sno",index=0)
    private String sno;//学号
    @Excel(name = "姓名")
    @ExcelProperty(value="sname",index=1)
    private String sname;//学生姓名
    @Excel(name = "性别")
    @ExcelProperty(value="ssex",index=2)
    private String ssex;//学生性别
    @Excel(name = "年级")
    @ExcelProperty(value="sqrade",index=3)
    private String sqrade;//年级
    @Excel(name = "班级")
    @ExcelProperty(value="sclass",index=4)
    private String sclass;//班级
    @Excel(name = "教学院")
    @ExcelProperty(value="sclass",index=5)

    private String sxy;//教学院

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

    public void setSxy(String sxy) {
        this.sxy = sxy;
    }

    public String getSxy() {
        return sxy;
    }

    @Override
    public String toString() {
        return "StuTy{" +
                "sno='" + sno + '\'' +
                ", sname='" + sname + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sqrade='" + sqrade + '\'' +
                ", sclass='" + sclass + '\'' +
                ", sxy='" + sxy + '\'' +
                '}';
    }


}
