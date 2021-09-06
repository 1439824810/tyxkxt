package com.example.spbmvc.vo;

import com.example.spbmvc.pojo.RkbTyLj;

import java.util.List;

public class RkbTyLjVo {
    private Integer page;

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

    public List<RkbTyLj> getRkbTyLj() {
        return rkbTyLj;
    }

    public void setRkbTyLj(List<RkbTyLj> rkbTyLj) {
        this.rkbTyLj = rkbTyLj;
    }

    private Integer pageSize;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    private List<RkbTyLj> rkbTyLj;
    private Long total;
    public static RkbTyLjVo data(Integer page, Integer pageSize ,Long total, List<RkbTyLj> rkbTyLj){
        RkbTyLjVo RkbTyLjVo =new RkbTyLjVo();
        RkbTyLjVo.setPage(page);
        RkbTyLjVo.setRkbTyLj(rkbTyLj);
        RkbTyLjVo.setPageSize(pageSize);

        RkbTyLjVo.setTotal(total);

        return RkbTyLjVo;
    }
}
