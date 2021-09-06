package com.example.spbmvc.controller;

import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.dto.StuTyDto;
import com.example.spbmvc.pojo.StuTy;
import com.example.spbmvc.service.StuTyService;
import com.example.spbmvc.vo.StuTyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tyxkxt")
public class StuTyController {
    @Autowired
    private StuTyService stuTyService;
    //    查询所有学生
    //    @Param("sname")String sname,@Param("sno")String sno,@Param("sxy")String sxy,@Param("sqrade")String sqrade
    @RequestMapping("stuSelectAll")
    public FormatterResponse stuSelectAll(Integer page,Integer pageSize, @RequestBody StuTyDto stuTyDto){
//        List<ClassTy> classTyList = classTyService.classSelectAll(page,pageSize,classSelectAllDto.getCname());
//        return FormatterResponse.ok(ClassTyVo.data(page,pageSize,classTyList));
        StuTyVo stuTIES = stuTyService.stuSelectAll(page,pageSize,stuTyDto.getSname(),stuTyDto.getSno(), stuTyDto.getSxy(),stuTyDto.getSqrade());
        return FormatterResponse.ok(stuTIES);
    }
//    通过ID查询
    @RequestMapping("stuSelectByTcid")
    public FormatterResponse stuSelectByTcid(@RequestBody StuTyDto stuTyDto){
        StuTyVo stuTIES = stuTyService.stuSelectByTcid(stuTyDto.getTcid());
        return FormatterResponse.ok(stuTIES);
    }
//    通过学号删除
    @RequestMapping("stuDeleteBySno")
    //    根据cid删除
    public FormatterResponse classDeleteById(@RequestBody StuTy stuTy){
        stuTyService.stuDeleteBySno(stuTy.getSno());
        return FormatterResponse.ok();
    }
    //    添加学生
    @RequestMapping("addStu")
    public FormatterResponse addStu(@RequestBody StuTy stuTy){
        stuTyService.addStu(stuTy);
        return FormatterResponse.ok();
    }
//    修改学生
    @RequestMapping("upadtStu")
    public FormatterResponse upadtStu(@RequestBody StuTy stuTy){
        stuTyService.upadtStu(stuTy);
        return FormatterResponse.ok();
    }

}
