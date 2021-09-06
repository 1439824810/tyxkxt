package com.example.spbmvc.vo;

import com.example.spbmvc.pojo.StuTy;

import java.util.List;

public class StuTyVo {
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
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

    public List<StuTy> getStuTyList() {
        return stuTyList;
    }

    public void setStuTyList(List<StuTy> stuTyList) {
        this.stuTyList = stuTyList;
    }
    public static StuTyVo data(Integer page, Integer pageSize ,Long total, List<StuTy> stuty){
        StuTyVo StuTyVo =new StuTyVo();
        StuTyVo.setPage(page);
        StuTyVo.setStuTyList(stuty);
        StuTyVo.setPageSize(pageSize);
        StuTyVo.setTotal(total);

        return StuTyVo;
    }
    private Integer pageSize;
    private List<StuTy> stuTyList;



    private Long total;
}
