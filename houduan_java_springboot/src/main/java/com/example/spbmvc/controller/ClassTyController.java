package com.example.spbmvc.controller;

import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.dto.ClassSelectAllDto;
import com.example.spbmvc.pojo.ClassTy;
import com.example.spbmvc.service.ClassTyService;
import com.example.spbmvc.vo.ClassTyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("tyxkxt")
public class ClassTyController {
    @Autowired
    private ClassTyService classTyService;
    //    查询所有课程
    @RequestMapping("classSelectAll")
    public FormatterResponse classSelectAll(Integer page,Integer pageSize, @RequestBody ClassSelectAllDto classSelectAllDto){
        ClassTyVo classTyList = classTyService.classSelectAll(page,pageSize,classSelectAllDto.getCname());
        return FormatterResponse.ok(classTyList);
    }
    @RequestMapping("classDeleteById")
    //    根据cid删除
    public FormatterResponse classDeleteById(@RequestBody ClassTy classTy){
        classTyService.deleteByCid(classTy.getCid());
//        FormatterResponse formatterResponse=new FormatterResponse();
//        formatterResponse.setMsg("ok");
//        formatterResponse.setStatus(200);
        return FormatterResponse.ok();
    }
    //    添加课程
    @RequestMapping("addClass")
    public FormatterResponse addClass(@RequestBody ClassTy classTy){
        classTyService.addClass(classTy);
//        FormatterResponse formatterResponse=new FormatterResponse();
//        formatterResponse.setMsg("ok");
//        formatterResponse.setStatus(200);
        return FormatterResponse.ok();
    }
//    修改课程
    @RequestMapping("upadteClass")
    public FormatterResponse upadteClass(@RequestBody ClassTy upadteClass){
        classTyService.upadteClass(upadteClass);
//        FormatterResponse formatterResponse=new FormatterResponse();
//        formatterResponse.setMsg("ok");
//        formatterResponse.setStatus(200);
        return FormatterResponse.ok();
    }

}
