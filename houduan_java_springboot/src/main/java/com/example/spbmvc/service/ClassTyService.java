package com.example.spbmvc.service;


import com.example.spbmvc.pojo.ClassTy;
import com.example.spbmvc.vo.ClassTyVo;

import java.util.List;

public interface ClassTyService {
    public ClassTyVo classSelectAll(Integer page, Integer pageSize, String cname);
    public void deleteByCid(Integer cid);
    public void addClass(ClassTy classTy);
    public void upadteClass(ClassTy upadteClass);
}
