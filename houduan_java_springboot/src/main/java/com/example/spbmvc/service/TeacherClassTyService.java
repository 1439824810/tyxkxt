package com.example.spbmvc.service;

import com.example.spbmvc.pojo.TeacherClassTy;
import com.example.spbmvc.vo.TeacherClassTyVo;

import java.util.List;

public interface TeacherClassTyService {
//    page,pageSize,teacherClassTyDto.getCname(),teacherClassTyDto.getTname(), teacherClassTyDto.getXq(),teacherClassTyDto.getSqrade(),teacherClassTyDto.getSksd(),teacherClassTyDto.getSksq()
public TeacherClassTyVo selectAllTeacherClass (Integer page, Integer pageSize, String cname, String tname, String xq, String sqrade, String sksd, String sksq);
    public TeacherClassTyVo selectAllTeacherClassNoIsend (Integer page, Integer pageSize, String cname, String tname, String xq, String sqrade, String sksd, String sksq);
    public void addTeacherClass( TeacherClassTy addTeacherClass);
    public void deleteTeacherClass(TeacherClassTy addTeacherClass);
    public void updateTeacherClass( TeacherClassTy updateTeacherClass);
    public List<TeacherClassTy> getXkInfo(String sno);
}
