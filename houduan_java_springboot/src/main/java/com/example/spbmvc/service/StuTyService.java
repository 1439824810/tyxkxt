package com.example.spbmvc.service;


import com.example.spbmvc.pojo.StuTy;
import com.example.spbmvc.vo.StuTyVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StuTyService {
//    page,pageSize,stuTy.getSname(),stuTy.getSno(),stuTy.getSsex(),stuTy.getSqrade()
    public StuTyVo stuSelectAll(Integer page, Integer pageSize, String sname, String sno, String sxy, String sqrade);
    public StuTyVo stuSelectByTcid(Integer tcid);
    //    根据tgh删除
    public void stuDeleteBySno(String sno);
    //    添加教师
    public void addStu(@Param("addStu") StuTy addStu);
    //    修改教师
    public void upadtStu(@Param("upadtStu") StuTy upadtStu);
}
