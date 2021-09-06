package com.example.spbmvc.service.impl;


import com.example.spbmvc.mapper.ClassTyMapper;
import com.example.spbmvc.mapper.StuTyMapper;
import com.example.spbmvc.pojo.ClassTy;
import com.example.spbmvc.pojo.StuTy;
import com.example.spbmvc.service.ClassTyService;
import com.example.spbmvc.service.StuTyService;
import com.example.spbmvc.vo.StuTyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuTyServiceImpl implements StuTyService {
    @Autowired
    private StuTyMapper stuTyMapper;
    //    根据cid删除
    @Override
    public StuTyVo stuSelectByTcid(Integer tcid) {
        List<StuTy> stuTIES = stuTyMapper.stuSelectByTcid(tcid);
        return StuTyVo.data(null,null,null,stuTIES);
    }
    @Override
    public void stuDeleteBySno(String sno) {
        stuTyMapper.stuDeleteBySno(sno);
    }
    //    查询所有课程
    @Override
    public StuTyVo stuSelectAll(Integer page,Integer pageSize,String sname,String sno,String sxy,String sqrade) {
//        pageHelper分页插件
        if(page!=null&&pageSize!=null){
            PageHelper.startPage(page,pageSize);
            List<StuTy> stuTIES = stuTyMapper.stuSelectAll(sname,sno,sxy,sqrade);
            PageInfo<StuTy> pageInfo =new PageInfo<>(stuTIES);
            Long pageTotal = pageInfo.getTotal();
            List<StuTy> stuTyList =  pageInfo.getList();
            return StuTyVo.data(page,pageSize,pageTotal,stuTyList);
        }else {
            List<StuTy> stuTIES = stuTyMapper.stuSelectAll(sname,sno,sxy,sqrade);
            return StuTyVo.data(page,pageSize,null,stuTIES);
        }
    }
    //    添加课程
    @Override
    public void addStu(StuTy addStu){
        stuTyMapper.addStu(addStu);
    }
//    修改课程
    @Override
    public void upadtStu(StuTy upadtStu) {
        stuTyMapper.upadtStu(upadtStu);
    }
}
