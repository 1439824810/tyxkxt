package com.example.spbmvc.controller;


import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.dto.UserTyQxDto;
import com.example.spbmvc.dto.UsersTyDto;
import com.example.spbmvc.mapper.UsersTyMapper;
import com.example.spbmvc.pojo.UsersTy;
import com.example.spbmvc.service.UsersService;
import com.example.spbmvc.vo.UserTyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tyxkxt")
public class UsersTyController {
    @Autowired
    private UsersService usersService;
//    查询所有用户
    @RequestMapping("usersSelectAll")
    public FormatterResponse usersSelectAll(Integer page, Integer pageSize, @RequestBody UsersTyDto usersTyDto){
        UserTyVo usersTyList = usersService.usersSelectAll(page,pageSize,usersTyDto.getTgh());
//        List<TeacherTy> teacherTyList = teacherTyService.teacherSelectAll(page,pageSize,teacherTyDto.getTgh(),teacherTyDto.getTname());
//        return FormatterResponse.ok(TeacherTyVo.data(page,pageSize,teacherTyList));
        return FormatterResponse.ok(usersTyList);
    }
//    登录
    @RequestMapping("login")
    public FormatterResponse login(Integer page, Integer pageSize, @RequestBody UsersTy usersTyDto){
        UserTyVo usersTyList = usersService.Login(page,pageSize,usersTyDto.getTgh());
        UsersTy user = new UsersTy();
        for (UsersTy usersTy : usersTyList.getUsersTyList()) {
            user = usersTy;
        }
        if (user.getPwd()!=null||user.getPwd()!=""){
            if (usersTyDto.getPwd().equals(user.getPwd())){
                for (UsersTy usersTy : usersTyList.getUsersTyList()) {
                    usersTy.setPwd(null);
                }
                return FormatterResponse.ok(usersTyList);
            }else {
                return FormatterResponse.error("密码错误");
            }
        }else if (user.getPwd().equals("")){
            return FormatterResponse.error("请输入密码");
        }else {

        }

//        List<TeacherTy> teacherTyList = teacherTyService.teacherSelectAll(page,pageSize,teacherTyDto.getTgh(),teacherTyDto.getTname());
//        return FormatterResponse.ok(TeacherTyVo.data(page,pageSize,teacherTyList));
//        return FormatterResponse.ok();
        return FormatterResponse.error("密码错误");
    }
    //    根据tgh删除
    @RequestMapping("usersDeleteByTgh")
    public FormatterResponse usersDeleteByTgh(@RequestBody UsersTy usersTy){
        usersService.usersDeleteByTgh(usersTy.getTgh());
        return FormatterResponse.ok();
    }
    //    添加用户
    @RequestMapping("addUsers")
    public FormatterResponse addUsers(@RequestBody UsersTy addUsers){
        usersService.addUsers(addUsers);
        return FormatterResponse.ok();
    }
    @Autowired
    UsersTyMapper usersTyMapper;
    //    修改用户
    @RequestMapping("upadtUsers")
    public FormatterResponse upadtUsers(@RequestBody UserTyQxDto upadtUsers){
        UsersTy usersTy = new UsersTy();
        usersTy.setTgh(upadtUsers.getTgh());
        usersTy.setTname(upadtUsers.getTname());
        usersTy.setJurisdiction(upadtUsers.getJurisdiction());
        if(upadtUsers.getPwd()!=null){
            usersTy.setPwd(upadtUsers.getPwd());
        }else if (upadtUsers.getPwd()==null){
            List<UsersTy> pwdList= usersTyMapper.usersSelectAll(upadtUsers.getTgh(),null);
            for (UsersTy ty : pwdList) {
                usersTy.setPwd(ty.getPwd());
            }
        }

        Integer currentTgh = upadtUsers.getCurrentTgh();
        Integer currentJurisdiction =0;
        List<UsersTy> usersTyListCurrent = usersTyMapper.usersSelectAll(currentTgh,null);
        for (UsersTy ty : usersTyListCurrent) {
            currentJurisdiction = ty.getJurisdiction();
        }
//        权限为100，随意
        if (currentJurisdiction==100){
            usersService.upadtUsers(usersTy);
            return FormatterResponse.ok();
//            权限大随意
        }else
            if (currentJurisdiction>usersTy.getJurisdiction()){
            if (currentJurisdiction!=usersTy.getJurisdiction()){
                return FormatterResponse.error("权限不足");
            }else {
                usersService.upadtUsers(usersTy);
                return FormatterResponse.ok();
            }

//            权限相同，人相同，随意
        }else if (currentJurisdiction==usersTy.getJurisdiction()&&currentTgh ==usersTy.getTgh()){
            usersService.upadtUsers(usersTy);
            return FormatterResponse.ok();

        }
        return FormatterResponse.error("权限不足");
    }
}
