package com.example.spbmvc.vo;

import com.example.spbmvc.pojo.ResultsTyLj;

import java.util.List;

public class ResultTyLjVo {
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

    public List<ResultsTyLj> getResultsTyLj() {
        return resultsTyLj;
    }

    public void setResultsTyLj(List<ResultsTyLj> resultsTyLj) {
        this.resultsTyLj = resultsTyLj;
    }

    private Integer page;
    private Integer pageSize;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    private List<ResultsTyLj> resultsTyLj;
    private Long total;
    public static ResultTyLjVo data(Integer page, Integer pageSize,Long total, List<ResultsTyLj> resultsTyLj){
        ResultTyLjVo ResultTyLjVo =new ResultTyLjVo();
        ResultTyLjVo.setPage(page);
        ResultTyLjVo.setResultsTyLj(resultsTyLj);
        ResultTyLjVo.setPageSize(pageSize);
        ResultTyLjVo.setTotal(total);

        return ResultTyLjVo;
    }
}
