package com.example.spbmvc.controller;



import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.dto.TeacherTyDto;
import com.example.spbmvc.pojo.TeacherTy;
import com.example.spbmvc.service.TeacherTyService;
import com.example.spbmvc.vo.TeacherTyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tyxkxt")
public class TeacherTyController {
    @Autowired
    private TeacherTyService teacherTyService;
    //    查询所有教师
    @RequestMapping("teacherSelectAll")
    public FormatterResponse teacherSelectAll(Integer page, Integer pageSize, @RequestBody TeacherTyDto teacherTyDto){
        TeacherTyVo teacherTyList = teacherTyService.teacherSelectAll(page,pageSize,teacherTyDto.getTgh(),teacherTyDto.getTname(),teacherTyDto.getRetired());
        return FormatterResponse.ok(teacherTyList);
    }
    @RequestMapping("teacherDeleteByTgh")
    //    根据cid删除
    public FormatterResponse teacherDeleteByTgh(@RequestBody TeacherTy deleteByTgh){
        teacherTyService.deleteByTgh(deleteByTgh.getTgh());
        return FormatterResponse.ok();
    }
    //    添加教师
    @RequestMapping("addTeacher")
    public FormatterResponse addTeacher(@RequestBody TeacherTy addTeacher){
//        System.out.println(addTeacher.toString());
        teacherTyService.addTeacher(addTeacher);
        return FormatterResponse.ok();
    }
    //    修改教师
    @RequestMapping("upadteTeacher")
    public FormatterResponse upadteTeacher(@RequestBody TeacherTy upadtTeacher){
        teacherTyService.upadtTeacher(upadtTeacher);
        return FormatterResponse.ok();
    }
}
