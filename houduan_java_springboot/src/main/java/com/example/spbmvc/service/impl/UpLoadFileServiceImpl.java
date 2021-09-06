package com.example.spbmvc.service.impl;

import com.example.spbmvc.mapper.StuTyMapper;
import com.example.spbmvc.pojo.StuTy;
import com.example.spbmvc.service.UpLoadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UpLoadFileServiceImpl implements UpLoadFileService {
@Autowired
private StuTyMapper stuTyMapper;
    @Override
    public void setStuInfo(Object stuInfo) {
        List<StuTy> stuTyList =((ArrayList<StuTy>) stuInfo);
        stuTyMapper.AddStuList(stuTyList);

    }
}
