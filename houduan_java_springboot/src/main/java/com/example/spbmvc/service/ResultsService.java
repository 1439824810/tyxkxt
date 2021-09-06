package com.example.spbmvc.service;

import com.example.spbmvc.pojo.ResultsTy;
import com.example.spbmvc.pojo.ResultsTyLj;
import com.example.spbmvc.vo.ResultTyLjVo;


import java.util.List;

public interface ResultsService {
    public ResultTyLjVo selectAllResults(Integer page, Integer pageSize, String sno , Integer tcid);
    public void addResults( ResultsTy addResults);
    public void updateResults( ResultsTy updateResults);
}
