package com.example.spbmvc.service.impl;


import com.example.spbmvc.mapper.ClassTyMapper;
import com.example.spbmvc.pojo.ClassTy;
import com.example.spbmvc.service.ClassTyService;
import com.example.spbmvc.vo.ClassTyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTyServiceImpl implements ClassTyService {
    @Autowired
    private ClassTyMapper classTyMapper;
    //    根据cid删除
    @Override
    public void deleteByCid(Integer cid) {
        classTyMapper.deleteByCid(cid);
    }
    //    查询所有课程
    @Override
    public ClassTyVo classSelectAll(Integer page, Integer pageSize, String cname) {
       if (page!=null&&pageSize!=null){
           PageHelper.startPage(page,pageSize);
           List<ClassTy> classTIES = classTyMapper.classSelectAll(cname);
           PageInfo<ClassTy> pageInfo =new PageInfo<>(classTIES);
           List<ClassTy> classTyList =  pageInfo.getList();
           Long pageTotal = pageInfo.getTotal();
           return ClassTyVo.data(page,pageSize,pageTotal,classTyList);
       }else {
           List<ClassTy> classTIES = classTyMapper.classSelectAll(cname);
           return ClassTyVo.data(page,pageSize,null,classTIES);
       }
    }
    //    添加课程
    @Override
    public void addClass(ClassTy classTy){
        classTyMapper.addClass(classTy);
    }
//    修改课程
    @Override
    public void upadteClass(ClassTy upadteClass) {
        classTyMapper.upadteClass(upadteClass);
    }
}
