package com.example.spbmvc.service;

import com.example.spbmvc.pojo.UsersTy;
import com.example.spbmvc.vo.UserTyVo;

import java.util.List;

public interface UsersService {
    public UserTyVo usersSelectAll(Integer page, Integer pageSize, Integer tgh);
    public UserTyVo Login(Integer page,Integer pageSize,Integer tgh);
    //    根据tgh删除
    public void usersDeleteByTgh(Integer tgh);
    //    添加教师
    public void addUsers( UsersTy addUsers);
    //    修改教师
    public void upadtUsers( UsersTy upadtUsers);
}
