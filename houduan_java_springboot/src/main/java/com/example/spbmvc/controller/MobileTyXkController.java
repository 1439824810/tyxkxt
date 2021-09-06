//package com.example.spbmvc.controller;
//
//import com.example.spbmvc.controller.formatter.FormatterMobileResponse;
//import com.example.spbmvc.pojo.*;
//import com.example.spbmvc.service.MobileTyXkService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("tyxkxt/mobile")
//public class MobileTyXkController {
//    @Autowired
//    private MobileTyXkService mobileTyXkService;
//    @RequestMapping("getClassTyList")
//    public FormatterMobileResponse getClassTyList(){
//        List<ClassTy> classTyList = mobileTyXkService.getClassTyList();
//        return FormatterMobileResponse.ok(classTyList);
//    }
//
//    @RequestMapping("getTeacherClassListByCid")
//    public FormatterMobileResponse getTeacherClassListByCid(Integer cid){
//        List<TeacherClassTy> teacherClassListByCid = mobileTyXkService.getTeacherClassListByCid(cid);
//        return FormatterMobileResponse.ok(teacherClassListByCid);
//    }
//    @RequestMapping("login")
//    public FormatterMobileResponse login(@RequestBody StuTy stuTy){
//        StuTy stu = mobileTyXkService.login(stuTy.getSno(), stuTy.getSname());
//        System.out.println(stuTy.toString());
////        System.out.println(stu.toString());
//        if(stu!=null){
//            if (stuTy.getSno()==null||stuTy.getSno()==""){
//                return FormatterMobileResponse.error("请输入学号");
//            }else if (stuTy.getSname()==null||stuTy.getSname()==""){
//                return FormatterMobileResponse.error("请输入姓名");
//            }else {
//                if(!stuTy.getSname().equals(stu.getSname())){
//                    return FormatterMobileResponse.error("姓名错误");
//                }else if (!stu.getSno().equals(stu.getSno())){
//                    return FormatterMobileResponse.error("学号错误");
//                }
//            }
//        }else {
//            return FormatterMobileResponse.error("学号错误");
//        }
//
//        return FormatterMobileResponse.ok(stu,"登录成功");
//    }
//
//    @RequestMapping("xk")
//    public FormatterMobileResponse xk(@RequestBody XkTy xkTy){
//        Boolean xk = mobileTyXkService.xk(xkTy.getSno(), xkTy.getTcid());
//        if (xk){
//            return FormatterMobileResponse.ok(null,"选课成功");
//        }else {
//            return FormatterMobileResponse.error("选课失败,人数已满");
//        }
//    }
//
//    @RequestMapping("cncleXk")
//    public FormatterMobileResponse cncleXk(@RequestBody XkTy xkTy){
//        System.out.println(xkTy.toString());
//        Boolean xk = mobileTyXkService.cncleXk(xkTy.getSno(), xkTy.getTcid());
//        if (xk){
//            return FormatterMobileResponse.ok(null,"取消成功");
//        }else {
//            return FormatterMobileResponse.error("取消失败，请联系管理员");
//        }
//    }
//
//    @RequestMapping("getXkInfo")
//    public FormatterMobileResponse getXkInfo(@RequestBody XkTy xkTy){
//        StuTeacherClassTyLj xkInfo = mobileTyXkService.getXkInfo(xkTy.getSno());
//        return FormatterMobileResponse.ok(xkInfo);
//    }
//}
