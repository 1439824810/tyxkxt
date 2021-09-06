package com.example.spbmvc.controller;

import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.dto.XkTyLjDto;
import com.example.spbmvc.pojo.XkTy;
import com.example.spbmvc.pojo.XkTyLj;
import com.example.spbmvc.service.XkTyService;
import com.example.spbmvc.vo.XkTyLjVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tyxkxt")
public class XkTyController {
    @Autowired
    private XkTyService xkTyService;
//    查询选课
    @RequestMapping("selectAllXk")
    public FormatterResponse selectAllXk(Integer page, Integer pageSize, @RequestBody XkTyLjDto xkTyLjDto) {
        XkTyLjVo xkTyLjs = xkTyService.selectAllXk(page,pageSize,xkTyLjDto.getSno(),xkTyLjDto.getCname(),xkTyLjDto.getTname(),xkTyLjDto.getXq(),xkTyLjDto.getSqrade(),xkTyLjDto.getSksd(),xkTyLjDto.getSksq());
        return FormatterResponse.ok(xkTyLjs);
    }
//    添加选课(选课)PC
    @RequestMapping("addXk")
    public FormatterResponse addXk(@RequestBody List<XkTyLj> addXk) {
        if(addXk.size()>0){
            boolean cf =  xkTyService.addXk(addXk);
            if (cf==true){
                return FormatterResponse.ok();
            }else {
                return FormatterResponse.error("添加学生重复");
            }

        }else {
            return FormatterResponse.error("学生不能为空");
        }

    }
    //    添加选课(选课)手机(前台)
    @RequestMapping("xk")
    public FormatterResponse xk(@RequestBody XkTy xkTy){
        Boolean xk = xkTyService.xk(xkTy);
        if (xk){
            return FormatterResponse.ok(null,"选课成功");
        }else {
            return FormatterResponse.error("选课失败 请不要重复选课");
        }
    }
//    撤销选课
    @RequestMapping("deleteXk")
    public FormatterResponse  deleteXk(@RequestBody XkTyLj deleteXk) {
        xkTyService.deleteXk(deleteXk);
        return FormatterResponse.ok();
    }
//    修改选课,好像没用
    @RequestMapping("updateXk")
    public FormatterResponse updateXk(@RequestBody XkTyLj updateXk) {
        xkTyService.updateXk(updateXk);
        return FormatterResponse.ok();
    }

}
