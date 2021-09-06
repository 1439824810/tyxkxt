package com.example.spbmvc.controller.formatter;
//返回JSON格式化
public class FormatterResponse {
    private Integer status;
    private String msg;

    public static FormatterResponse ok(){
        FormatterResponse formatterResponse = new FormatterResponse();
        formatterResponse.setStatus(200);
        formatterResponse.setData(null);
        formatterResponse.setMsg("ok");
        return formatterResponse;
    }

    public static FormatterResponse ok(Object o,String msg){
        FormatterResponse formatterResponse = new FormatterResponse();
        formatterResponse.setStatus(200);
        formatterResponse.setData(o);
        formatterResponse.setMsg(msg);
        return formatterResponse;
    }

    public static FormatterResponse ok(Object o){
        FormatterResponse formatterResponse = new FormatterResponse();
        formatterResponse.setStatus(200);
        formatterResponse.setData(o);
        formatterResponse.setMsg("");
        return formatterResponse;
    }

    public static FormatterResponse error(String str){
        FormatterResponse formatterResponse = new FormatterResponse();
        formatterResponse.setStatus(500);
        formatterResponse.setData(null);
        formatterResponse.setMsg(str);
        return formatterResponse;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private Object data;
}
