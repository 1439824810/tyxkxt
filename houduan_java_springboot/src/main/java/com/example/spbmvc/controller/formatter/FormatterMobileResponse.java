//package com.example.spbmvc.controller.formatter;
////手机端格式化返回信息
//public class FormatterMobileResponse {
//    private Integer code;
//    private String msg;
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public static FormatterMobileResponse ok(){
//        FormatterMobileResponse formatterResponse = new FormatterMobileResponse();
//        formatterResponse.setCode(0);
//        formatterResponse.setData(null);
//        formatterResponse.setMsg("ok");
//        return formatterResponse;
//    }
//
//    public static FormatterMobileResponse ok(Object o, String msg){
//        FormatterMobileResponse formatterResponse = new FormatterMobileResponse();
//        formatterResponse.setCode(0);
//        formatterResponse.setData(o);
//        formatterResponse.setMsg(msg);
//        return formatterResponse;
//    }
//
//    public static FormatterMobileResponse ok(Object o){
//        FormatterMobileResponse formatterResponse = new FormatterMobileResponse();
//        formatterResponse.setCode(0);
//        formatterResponse.setData(o);
//        formatterResponse.setMsg("");
//        return formatterResponse;
//    }
//
//    public static FormatterMobileResponse error(String str){
//        FormatterMobileResponse formatterResponse = new FormatterMobileResponse();
//        formatterResponse.setCode(500);
//        formatterResponse.setData(null);
//        formatterResponse.setMsg(str);
//        return formatterResponse;
//    }
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//
//    public Object getData() {
//        return data;
//    }
//
//    public void setData(Object data) {
//        this.data = data;
//    }
//
//    private Object data;
//}
