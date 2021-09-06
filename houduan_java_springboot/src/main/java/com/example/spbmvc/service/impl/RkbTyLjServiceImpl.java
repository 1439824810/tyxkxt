package com.example.spbmvc.service.impl;

import com.example.spbmvc.mapper.RkbTyLjMapper;
import com.example.spbmvc.pojo.RkbTy;
import com.example.spbmvc.pojo.RkbTyLj;
import com.example.spbmvc.service.RkbTyLjService;
import com.example.spbmvc.vo.RkbTyLjVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RkbTyLjServiceImpl implements RkbTyLjService{
    @Autowired
    private RkbTyLjMapper rkbTyLjMapper;
    @Override
//    public List<RkbTyLj> selectAllRkbTyLj (Integer page, Integer pageSize,Integer tgh,String tname ,String cname);
    public RkbTyLjVo selectAllRkbTyLj(Integer page, Integer pageSize,Integer tgh,String tname ,String cname) {
        PageHelper.startPage(page,pageSize);
        List<RkbTyLj> rkbTyLjs = rkbTyLjMapper.selectAllRkbTyLj(tgh,tname,cname);
        PageInfo<RkbTyLj> rkbTyLjPageInfo =new PageInfo<>(rkbTyLjs);
        Long pageTotal = rkbTyLjPageInfo.getTotal();
        List<RkbTyLj> list = rkbTyLjPageInfo.getList();
        return RkbTyLjVo.data(page,pageSize,pageTotal,list);
    }

    @Override
    public void addRkbTy(RkbTy addRkbTy) {
        rkbTyLjMapper.addRkbTy(addRkbTy);
    }

    @Override
    public void deleteRkbTy(RkbTy deleteRkbTy) {
        rkbTyLjMapper.deleteRkbTy(deleteRkbTy.getId());
    }

    @Override
    public void updateRkbTy(RkbTy updateRkbTy) {
        rkbTyLjMapper.updateRkbTy(updateRkbTy);
    }
}
