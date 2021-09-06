package com.example.spbmvc.controller;

import com.example.spbmvc.controller.formatter.FormatterResponse;
import com.example.spbmvc.service.QywxGetUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tyxkxt")
public class QywxGetUserInfoController {
    private String corpid = "wwfce60765bbd07487";
    private String corpsecret = "60IvI6D2cO1iqpnJ4Rc9Hc9faNHJpael06omUDcuP5I";
    private String access_token="";
    private String code="";
    private String UserId="";
    @Autowired
    private QywxGetUserInfoService qywxGetUserInfoService;
//    获取企业微信信息的接口
    @RequestMapping("getqywxInfo")
    public FormatterResponse  getqywxInfo(String code){
        this.code = code;
        String URL1 = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+corpsecret;
        String access_token = qywxGetUserInfoService.postAccessToken(URL1);
        System.out.println(access_token);
        this.access_token =access_token;
        String URL2 = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+access_token+"&code="+code;
        String UserId = qywxGetUserInfoService.getInfoByTokenAndCode(URL2);
        System.out.println(UserId);
        this.UserId = UserId;
//        String URL3 ="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+access_token+"&code="+code;
//        String UserInfo = qywxGetUserInfoService.postUserInfoByUserIdAndAccessToken(URL3);
//        System.out.println(UserInfo);
        return FormatterResponse.ok(this.UserId);
    }
}
