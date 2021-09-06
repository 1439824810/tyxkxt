package com.example.spbmvc.service.impl;

import com.example.spbmvc.mapper.ResultsTyMapper;
import com.example.spbmvc.pojo.ResultsTy;
import com.example.spbmvc.pojo.ResultsTyLj;
import com.example.spbmvc.service.ResultsService;
import com.example.spbmvc.vo.ResultTyLjVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResultsServiceImpl  implements ResultsService{
    @Autowired
    private ResultsTyMapper resultsTyMapper;
    @Override
    public ResultTyLjVo selectAllResults(Integer page, Integer pageSize, String sno , Integer tcid) {
        if (page!=null&&pageSize!=null){
            PageHelper.startPage(page,pageSize);
            List<ResultsTyLj> resultsTyLjs = resultsTyMapper.selectAllResults(sno, tcid);
            PageInfo<ResultsTyLj> resultsTyLjPageInfo =new PageInfo<>(resultsTyLjs);
            Long pageTotal = resultsTyLjPageInfo.getTotal();
            List<ResultsTyLj> list = resultsTyLjPageInfo.getList();
            return ResultTyLjVo.data(page,pageSize,pageTotal,list);
        }else {
            List<ResultsTyLj> resultsTyLjs = resultsTyMapper.selectAllResults(sno, tcid);
            return ResultTyLjVo.data(page,pageSize,null,resultsTyLjs);
        }
    }

    @Override
    public void addResults(ResultsTy addResults) {
        resultsTyMapper.addResults(addResults);
    }

    @Override
    public void updateResults(ResultsTy updateResults) {
        System.out.println("updateResults.toString()"+updateResults.toString());
        resultsTyMapper.updateResults(updateResults);
    }
}
