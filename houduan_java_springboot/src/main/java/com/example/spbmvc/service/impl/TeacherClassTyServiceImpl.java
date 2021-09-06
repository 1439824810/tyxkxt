package com.example.spbmvc.service.impl;

import com.example.spbmvc.mapper.ClassTyMapper;
import com.example.spbmvc.mapper.TeacherClassTyMapper;
import com.example.spbmvc.mapper.TeacherTyMapper;
import com.example.spbmvc.pojo.ClassTy;
import com.example.spbmvc.pojo.TeacherClassTy;
import com.example.spbmvc.pojo.TeacherTy;
import com.example.spbmvc.service.TeacherClassTyService;
import com.example.spbmvc.vo.TeacherClassTyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherClassTyServiceImpl implements TeacherClassTyService {
    @Autowired
    private TeacherClassTyMapper teacherClassTyMapper;
    @Autowired
    private TeacherTyMapper teacherTyMapper;
    @Autowired
    private ClassTyMapper classTyMapper;
    @Override
    public TeacherClassTyVo selectAllTeacherClass(Integer page, Integer pageSize, String cname, String tname, String xq, String sqrade, String sksd, String sksq) {
        if (page!=null&&pageSize!=null){
            PageHelper.startPage(page,pageSize);
            List<TeacherClassTy> teacherClassTyList = teacherClassTyMapper.selectAllTeacherClass(cname,tname,xq,sqrade,sksd,sksq);
            PageInfo<TeacherClassTy> pageInfo =new PageInfo<>(teacherClassTyList);
            Long pageTotal = pageInfo.getTotal();
            List<TeacherClassTy> teacherClassTIES =  pageInfo.getList();
            return TeacherClassTyVo.data(page,pageSize,pageTotal,teacherClassTIES);
        }else {
            List<TeacherClassTy> teacherClassTyList = teacherClassTyMapper.selectAllTeacherClassSqrade();
            return TeacherClassTyVo.data(page,pageSize,null,teacherClassTyList);
        }
    }
    @Override
    public TeacherClassTyVo selectAllTeacherClassNoIsend(Integer page, Integer pageSize, String cname, String tname, String xq, String sqrade, String sksd, String sksq) {
        PageHelper.startPage(page,pageSize);
        List<TeacherClassTy> teacherClassTyList = teacherClassTyMapper.selectAllTeacherClassNoIsend(cname,tname,xq,sqrade,sksd,sksq);
        PageInfo<TeacherClassTy> pageInfo =new PageInfo<>(teacherClassTyList);
        Long pageTotal = pageInfo.getTotal();
        List<TeacherClassTy> teacherClassTIES =  pageInfo.getList();
        return TeacherClassTyVo.data(page,pageSize,pageTotal,teacherClassTIES);
    }

    @Override
    public void addTeacherClass(TeacherClassTy addTeacherClass) {
        String tname = null;
        Integer cid=null;
        if (addTeacherClass.getTname()==null||addTeacherClass.getTname()==""){
            List<TeacherTy> teacherTyList= teacherTyMapper.teacherSelectAll(addTeacherClass.getTgh(),null,null);
            for (TeacherTy teacherTy : teacherTyList) {
                tname =teacherTy.getTname();
            }
            addTeacherClass.setTname(tname);
        }
        if (addTeacherClass.getCid()==null){
           List<ClassTy> classes =classTyMapper.classSelectAll(addTeacherClass.getCname());
            for (ClassTy aClass : classes) {
                cid = aClass.getCid();
            }
            addTeacherClass.setCid(cid);
        }
        teacherClassTyMapper.addTeacherClass(addTeacherClass);
    }

    @Override
    public void deleteTeacherClass(TeacherClassTy addTeacherClass) {
        teacherClassTyMapper.deleteTeacherClass(addTeacherClass.getTcid());
    }

    @Override
    public void updateTeacherClass(TeacherClassTy updateTeacherClass) {
        System.out.println(updateTeacherClass.toString());
        if(updateTeacherClass.getIsend().equals("0")){
            teacherClassTyMapper.JieKe(updateTeacherClass);
        }else {
            teacherClassTyMapper.updateTeacherClass(updateTeacherClass);
        }

    }
    @Override
    public List<TeacherClassTy> getXkInfo( String sno){
        List<TeacherClassTy> xkInfo = teacherClassTyMapper.getXkInfo(sno);
        return xkInfo;
    }
}
