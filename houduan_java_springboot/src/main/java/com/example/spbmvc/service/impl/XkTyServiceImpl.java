package com.example.spbmvc.service.impl;

import com.example.spbmvc.mapper.TeacherClassTyMapper;
import com.example.spbmvc.mapper.XkTyMapper;
import com.example.spbmvc.pojo.TeacherClassTy;
import com.example.spbmvc.pojo.XkTy;
import com.example.spbmvc.pojo.XkTyLj;
import com.example.spbmvc.service.XkTyService;
import com.example.spbmvc.vo.XkTyLjVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class XkTyServiceImpl implements XkTyService {
    @Autowired
    private XkTyMapper xkTyMapper;
    @Autowired
    private TeacherClassTyMapper teacherClassTyMapper;
    @Override
    public XkTyLjVo selectAllXk(Integer page, Integer pageSize,String sno,String cname,String tname,String xq,String sqrade,String sksd,String sksq) {
        PageHelper.startPage(page,pageSize);
        List<XkTyLj> xkTyLjList = xkTyMapper.selectAllXk(sno,cname,tname,xq,sqrade,sksq,sksd);
        PageInfo<XkTyLj> pageInfo =new PageInfo<>(xkTyLjList);
        Long pageTotal = pageInfo.getTotal();
        List<XkTyLj> xkTyLjs =  pageInfo.getList();
        return XkTyLjVo.data(page,pageSize,pageTotal,xkTyLjs);
    }

    @Override
    public Boolean xk(XkTy xkTy) {
//        已经选课的人数
        Integer countBKNum = xkTyMapper.countBKNum(xkTy.getTcid());
//        设定好的选课人数
        TeacherClassTy selectXkNum = teacherClassTyMapper.selectXkNum(xkTy.getTcid());
        if(countBKNum>=selectXkNum.getRsxz()){
            return false;
        }else {
            XkTyLj xkTyLj = new XkTyLj();
            xkTyLj.setSno(xkTy.getSno());
            xkTyLj.setTcid(xkTy.getTcid());
            Integer num = xkTyMapper.countXk(xkTyLj);
            if (num<=0){
                xkTyMapper.addXk(xkTyLj);
                teacherClassTyMapper.updateTeacherClassAddNum(xkTyLj.getTcid());
                return true;
            }
            return false;
        }

    }
    @Override
    public boolean addXk(List<XkTyLj> addXk) {
        boolean xkCf = true;
        for (XkTyLj xkTyLj : addXk) {
           Integer integer= xkTyMapper.countXk(xkTyLj);
            System.out.println("i="+integer);
            if (integer>0){
                xkCf = false;
            }
        }
        if(xkCf==true){
            for (XkTyLj xkTyLj : addXk) {
                xkTyMapper.addXk(xkTyLj);
            }
        }
        return xkCf;
    }

    @Override
    public void deleteXk(XkTyLj deleteXk) {
        xkTyMapper.deleteXk(deleteXk);
        System.out.println("deleteXk"+deleteXk.toString());
    }

    @Override
    public void updateXk(XkTyLj updateXk) {
        xkTyMapper.updateXk(updateXk);
    }
}
