package com.example.spbmvc.service.impl;



import com.example.spbmvc.mapper.TeacherTyMapper;
import com.example.spbmvc.pojo.TeacherTy;
import com.example.spbmvc.service.TeacherTyService;
import com.example.spbmvc.vo.TeacherTyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherTyServiceImpl implements TeacherTyService{
    @Autowired
    private TeacherTyMapper teacherTyMapper;
    public TeacherTyVo teacherSelectAll(Integer page, Integer pageSize, Integer tgh, String tname,String retired){
        if(page!=null&&pageSize!=null){
            PageHelper.startPage(page,pageSize);
            List<TeacherTy> teacherTyList = teacherTyMapper.teacherSelectAll(tgh,tname,retired);
            PageInfo<TeacherTy> pageInfo =new PageInfo<>(teacherTyList);
            Long pageTotal = pageInfo.getTotal();
            List<TeacherTy> classTyList =  pageInfo.getList();
            return TeacherTyVo.data(page,pageSize,pageTotal,classTyList);
        }else {
            List<TeacherTy> teacherTyList = teacherTyMapper.teacherSelectAll(tgh,tname,retired);
            return TeacherTyVo.data(page,pageSize,null,teacherTyList);
        }
    }
    //    根据tgh删除
    public void deleteByTgh(Integer tgh){
        teacherTyMapper.deleteByTgh(tgh);

    }
    //    添加教师
    public void addTeacher( TeacherTy addTeacher){
        teacherTyMapper.addTeacher(addTeacher);

    }
    //    修改教师
    public void upadtTeacher( TeacherTy upadtTeacher){
        teacherTyMapper.upadtTeacher(upadtTeacher);
    }
}
