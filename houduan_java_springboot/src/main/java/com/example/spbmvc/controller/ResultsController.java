package com.example.spbmvc.controller;

import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.dto.ResultTyLjDto;
import com.example.spbmvc.pojo.ResultsTy;
import com.example.spbmvc.pojo.ResultsTyLj;
import com.example.spbmvc.service.ResultsService;
import com.example.spbmvc.vo.ResultTyLjVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tyxkxt")
//可以通过excel导出每一节课的成绩
public class ResultsController {
    @Autowired
//    查询所有成绩
    private ResultsService resultsService;
    @RequestMapping("selectAllResults")
    public FormatterResponse selectAllResults(Integer page,Integer pageSize, @RequestBody ResultTyLjDto resultTyLjDto) {
        System.out.println("resultTyLjDto.toString()"+resultTyLjDto.toString());
        ResultTyLjVo results = resultsService.selectAllResults(page,pageSize, resultTyLjDto.getSno(), resultTyLjDto.getTcid());
        return FormatterResponse.ok(results);
    }
//    添加成绩
    @RequestMapping("addResults")
    public FormatterResponse addResults(@RequestBody ResultsTy addResults) {
        System.out.println(addResults.toString());
        resultsService.addResults(addResults);
//        FormatterResponse formatterResponse=new FormatterResponse();
//        formatterResponse.setMsg("ok");
//        formatterResponse.setStatus(200);
        return FormatterResponse.ok();
    }
//    修改成绩
    @RequestMapping("updateResults")
    public FormatterResponse updateResults(@RequestBody ResultsTy updateResults) {
        System.out.println(updateResults.toString());
        resultsService.updateResults(updateResults);
//        FormatterResponse formatterResponse=new FormatterResponse();
//        formatterResponse.setMsg("ok");
//        formatterResponse.setStatus(200);
        return FormatterResponse.ok();
    }
}
