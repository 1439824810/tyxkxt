//package com.example.spbmvc.service.impl;
//
//import com.example.spbmvc.mapper.*;
//import com.example.spbmvc.pojo.*;
//import com.example.spbmvc.service.MobileTyXkService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//@Service
//public class MobileTyXkServiceImpl implements MobileTyXkService {
//    @Autowired
//    private ClassTyMapper classTyMapper;
//    @Autowired
//    private TeacherClassTyMapper teacherClassTyMapper;
//    @Autowired
//    private StuTyMapper stuTyMapper;
//    @Autowired
//    private XkTyMapper xkTyMapper;
//    @Autowired
//    private StuTeacherClassTyLjMapper stuTeacherClassTyLjMapper;
//    @Override
//    public List<ClassTy> getClassTyList() {
//        List<ClassTy> classTyList = classTyMapper.classSelectAll(null);
//        return classTyList;
//    }
//
//    @Override
//    public List<TeacherClassTy> getTeacherClassListByCid(Integer cid) {
//        List<TeacherClassTy> teacherClassTIES = teacherClassTyMapper.selectTeacherClassTybyCid(cid);
//        return teacherClassTIES;
//    }
//
//    @Override
//    public StuTy login(String sno,String sname) {
//        List<StuTy> stuTyList = stuTyMapper.stuSelectAll(sname, sno, null, null);
//        StuTy stu =null;
//        for (StuTy stuTy : stuTyList) {
//            stu = stuTy;
//        }
//        return stu;
//    }
//
//    @Override
//    public Boolean xk(String sno, Integer tcid) {
//        Integer countBKNum = xkTyMapper.countBKNum(tcid);
//        TeacherClassTy selectXkNum = teacherClassTyMapper.selectXkNum(tcid);
//        if(countBKNum>=selectXkNum.getRsxz()){
//            return false;
//        }else {
//            XkTyLj xkTyLj = new XkTyLj();
//            xkTyLj.setSno(sno);
//            xkTyLj.setTcid(tcid);
//            xkTyMapper.addXk(xkTyLj);
//            return true;
//        }
//
//    }
//
//    @Override
//    public Boolean cncleXk(String sno, Integer tcid) {
//        XkTyLj xkTyLj =new XkTyLj();
//        xkTyLj.setSno(sno);
//        xkTyLj.setTcid(tcid);
//        xkTyMapper.deleteXk(xkTyLj);
//        return true;
//    }
//
//    @Override
//    public StuTeacherClassTyLj getXkInfo(String sno) {
//        Date date =new Date();
//        long time = date.getTime();
//        DateFormat dateFormat =new SimpleDateFormat("YYYY-MM-dd");
//        String format = dateFormat.format(time);
//        String[] split = format.split("-");
//        List<StuTy> stuTyList = stuTyMapper.stuSelectAll(null, sno, null, null);
//        if (stuTyList.size()<=0){
//            return null;
//        }
//        String stuTime = null;
//        for (StuTy stuTy : stuTyList) {
//            stuTime =stuTy.getSqrade();
//        }
//        System.out.println("split[0]"+split[0]);
//        System.out.println("stuTime"+stuTime);
//        System.out.println("stuTime+\"-1\""+stuTime+"-2");
//        StuTeacherClassTyLj lastXkInfo =null;
//        if (stuTime.equals(split[0])){
//            lastXkInfo = stuTeacherClassTyLjMapper.getLastXkInfo(stuTime+"-1",sno);
//        }else {
//            lastXkInfo = stuTeacherClassTyLjMapper.getLastXkInfo(stuTime+"-2",sno);
//        }
//        return lastXkInfo;
//    }
//}
