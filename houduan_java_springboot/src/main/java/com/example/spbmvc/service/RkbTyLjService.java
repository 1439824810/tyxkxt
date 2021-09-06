package com.example.spbmvc.service;

import com.example.spbmvc.pojo.RkbTy;
import com.example.spbmvc.pojo.RkbTyLj;
import com.example.spbmvc.vo.RkbTyLjVo;

import java.util.List;

public interface RkbTyLjService {
    public RkbTyLjVo selectAllRkbTyLj (Integer page, Integer pageSize, Integer tgh, String tname , String cname);
    public void addRkbTy( RkbTy addRkbTy);
    public void deleteRkbTy(RkbTy deleteRkbTy);
    public void updateRkbTy( RkbTy updateRkbTy);
}
