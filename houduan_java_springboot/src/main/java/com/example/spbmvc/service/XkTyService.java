package com.example.spbmvc.service;

import com.example.spbmvc.pojo.XkTy;
import com.example.spbmvc.pojo.XkTyLj;
import com.example.spbmvc.vo.XkTyLjVo;

import java.util.List;

public interface XkTyService {
    public XkTyLjVo selectAllXk(Integer page, Integer pageSize, String sno, String cname, String tname, String xq, String sqrade, String sksd, String sksq);
    public boolean addXk(List<XkTyLj> addXk);
    public void deleteXk(XkTyLj deleteXk);
    public void updateXk(XkTyLj updateXk);
    public Boolean xk(XkTy xk);
}
