package com.example.spbmvc.service;

import com.example.spbmvc.pojo.TeacherTy;
import com.example.spbmvc.vo.TeacherTyVo;

import java.util.List;

public interface TeacherTyService {
//    page,pageSize,teacherTyDto.getTgh(),teacherTyDto.getTname()
    public TeacherTyVo teacherSelectAll(Integer page, Integer pageSize, Integer tgh, String tname,String retired);
    //    根据tgh删除
    public void deleteByTgh(Integer tgh);
    //    添加教师
    public void addTeacher( TeacherTy addTeacher);
    //    修改教师
    public void upadtTeacher( TeacherTy upadtTeacher);
}
