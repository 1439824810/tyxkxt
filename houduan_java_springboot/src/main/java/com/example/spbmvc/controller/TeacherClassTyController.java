package com.example.spbmvc.controller;

import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.dto.TeacherClassTyDto;
import com.example.spbmvc.pojo.StuTy;
import com.example.spbmvc.pojo.TeacherClassTy;
import com.example.spbmvc.service.TeacherClassTyService;
import com.example.spbmvc.vo.TeacherClassTyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tyxkxt")
public class TeacherClassTyController {
    @Autowired
//    查询所有班课
    private TeacherClassTyService teacherClassTyService;
    @RequestMapping("selectAllTeacherClass")
    public FormatterResponse selectAllTeacherClass(Integer page,Integer pageSize, @RequestBody TeacherClassTyDto teacherClassTyDto) {
        System.out.println(teacherClassTyDto.toString());
        TeacherClassTyVo teacherClassTyList = teacherClassTyService.selectAllTeacherClass(page,pageSize,teacherClassTyDto.getCname(),teacherClassTyDto.getTname(), teacherClassTyDto.getXq(),teacherClassTyDto.getSqrade(),teacherClassTyDto.getSksd(),teacherClassTyDto.getSksq());
        return FormatterResponse.ok(teacherClassTyList);
    }
//获取选课信息
    @RequestMapping("getXkInfo")
    public FormatterResponse getXkInfo(@RequestBody StuTy stuTy) {
        System.out.println(stuTy.getSno());
        List<TeacherClassTy> xkInfo = teacherClassTyService.getXkInfo(stuTy.getSno());
        return FormatterResponse.ok(xkInfo);
    }
//    查询没有结课的
    @RequestMapping("selectAllTeacherClassNoIsend")
    public FormatterResponse selectAllTeacherClassNoIsend(Integer page,Integer pageSize, @RequestBody TeacherClassTyDto teacherClassTyDto) {
        System.out.println(teacherClassTyDto.toString());
        TeacherClassTyVo teacherClassTyList = teacherClassTyService.selectAllTeacherClassNoIsend(page,pageSize,teacherClassTyDto.getCname(),teacherClassTyDto.getTname(), teacherClassTyDto.getXq(),teacherClassTyDto.getSqrade(),teacherClassTyDto.getSksd(),teacherClassTyDto.getSksq());
        return FormatterResponse.ok(teacherClassTyList);
    }
//    添加班课
    @RequestMapping("addTeacherClass")
    public FormatterResponse addTeacherClass(@RequestBody TeacherClassTy addTeacherClass) {
        System.out.println(addTeacherClass);
        teacherClassTyService.addTeacherClass(addTeacherClass);
        return FormatterResponse.ok();
    }
//    删除班课
    @RequestMapping("deleteTeacherClass")
    public FormatterResponse deleteTeacherClass(@RequestBody TeacherClassTy deleteTeacherClass) {
        teacherClassTyService.deleteTeacherClass(deleteTeacherClass);
        return FormatterResponse.ok();
    }
//    修改班课
    @RequestMapping("updateTeacherClass")
    public FormatterResponse updateRkbTy(@RequestBody TeacherClassTy updateTeacherClass) {
        teacherClassTyService.updateTeacherClass(updateTeacherClass);
        return FormatterResponse.ok();
    }
}
