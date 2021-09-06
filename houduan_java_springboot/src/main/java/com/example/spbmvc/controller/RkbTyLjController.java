package com.example.spbmvc.controller;

import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.dto.RkbTyLjDto;
import com.example.spbmvc.pojo.RkbTy;
import com.example.spbmvc.pojo.RkbTyLj;
import com.example.spbmvc.service.RkbTyLjService;
import com.example.spbmvc.vo.RkbTyLjVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tyxkxt")
public class RkbTyLjController {
    @Autowired
    private RkbTyLjService rkbTyLjService;
//    查询所有任课教师
    @RequestMapping("selectAllRkbTyLj")
    public FormatterResponse selectAllRkbTyLj(Integer page,Integer pageSize, @RequestBody RkbTyLjDto rkbTyLjDto) {
        RkbTyLjVo rkbTyLjs = rkbTyLjService.selectAllRkbTyLj(page, pageSize, rkbTyLjDto.getTgh(), rkbTyLjDto.getTname(), rkbTyLjDto.getCname());
        return FormatterResponse.ok(rkbTyLjs);
    }
//    添加任课
    @RequestMapping("addRkbTy")
    public FormatterResponse addRkbTy(@RequestBody RkbTy addRkbTy) {
        rkbTyLjService.addRkbTy(addRkbTy);
        return FormatterResponse.ok();
    }
//    删除
    @RequestMapping("deleteRkbTy")
    public FormatterResponse deleteRkbTy(@RequestBody RkbTy deleteRkbTy) {
        rkbTyLjService.deleteRkbTy(deleteRkbTy);
        return FormatterResponse.ok();
    }
//    修改
    @RequestMapping("updateRkbTy")
    public FormatterResponse updateRkbTy(@RequestBody RkbTy updateRkbTy) {
        rkbTyLjService.updateRkbTy(updateRkbTy);
        return FormatterResponse.ok();
    }
}
