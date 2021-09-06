package com.example.spbmvc.service.impl;

import com.example.spbmvc.mapper.UsersTyMapper;
import com.example.spbmvc.pojo.UsersTy;
import com.example.spbmvc.service.UsersService;
import com.example.spbmvc.vo.UserTyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersTyMapper usersTyMapper;

    @Override
    public UserTyVo usersSelectAll(Integer page,Integer pageSize,Integer tgh) {
        if(tgh==null){
            return UserTyVo.data(page,pageSize,null,null);
        }else {
            Integer jurisdiction = null;
            List<UsersTy> jurisdictions= usersTyMapper.usersSelectAll(tgh,null);
            for (UsersTy usersTy : jurisdictions) {
                jurisdiction= usersTy.getJurisdiction();
            }
            PageHelper.startPage(page,pageSize);
            List<UsersTy> usersTyList = usersTyMapper.usersSelectAll(null,jurisdiction);
            PageInfo<UsersTy> pageInfo =new PageInfo<>(usersTyList);
            Long pageTotal = pageInfo.getTotal();
            List<UsersTy> usersTIES =  pageInfo.getList();
            for (UsersTy usersTY : usersTIES) {
                usersTY.setPwd(null);
            }
            return UserTyVo.data(page,pageSize,pageTotal,usersTIES);
        }
    }
    @Override
    public UserTyVo Login(Integer page,Integer pageSize,Integer tgh) {
        PageHelper.startPage(page,pageSize);
        List<UsersTy> usersTyList = usersTyMapper.usersSelectAll(tgh,null);
        PageInfo<UsersTy> pageInfo =new PageInfo<>(usersTyList);
        Long pageTotal = pageInfo.getTotal();
        List<UsersTy> usersTIES =  pageInfo.getList();
        return UserTyVo.data(page,pageSize,pageTotal,usersTIES);
    }
    @Override
    public void usersDeleteByTgh(Integer tgh) {
        usersTyMapper.usersDeleteByTgh(tgh);
    }

    @Override
    public void addUsers(UsersTy addUsers) {
        usersTyMapper.addUsers(addUsers);
    }

    @Override
    public void upadtUsers(UsersTy upadtUsers) {
        usersTyMapper.upadtUsers(upadtUsers);
    }
}
