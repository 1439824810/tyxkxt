package com.example.spbmvc.vo;

import com.example.spbmvc.pojo.XkTyLj;

import java.util.List;

public class XkTyLjVo {
    private Integer page;
    private Integer pageSize;
    private List<XkTyLj> xkTyLjList;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    private Long total;


    //    page,pageSize,xkTyLjDto.getSno(),xkTyLjDto.getCname(),xkTyLjDto.getTname(),xkTyLjDto.getXq(),xkTyLjDto.getSqrade(),xkTyLjDto.getSksd(),xkTyLjDto.getSksq()
    public static XkTyLjVo data(Integer page, Integer pageSize,Long total, List<XkTyLj> xkTyLjList){
        XkTyLjVo XkTyLjVo =new XkTyLjVo();
        XkTyLjVo.setPage(page);
        XkTyLjVo.setXkTyLjList(xkTyLjList);
        XkTyLjVo.setPageSize(pageSize);
        XkTyLjVo.setTotal(total);

        return XkTyLjVo;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<XkTyLj> getXkTyLjList() {
        return xkTyLjList;
    }

    public void setXkTyLjList(List<XkTyLj> xkTyLjList) {
        this.xkTyLjList = xkTyLjList;
    }
}
