package com.example.spbmvc.vo;

import com.example.spbmvc.pojo.ClassTy;

import java.util.List;

public class ClassTyVo {
    private Integer page;
    private Integer pageSize;

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

    public List<ClassTy> getClassTy() {
        return classTy;
    }

    public void setClassTy(List<ClassTy> classTy) {
        this.classTy = classTy;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "ClassTyVo{" +

                "page=" + page +
                ", pageSize=" + pageSize +
                ", classTy=" + classTy +
                ", total=" + total +
                '}';
    }

    public static ClassTyVo data(Integer page, Integer pageSize, Long total, List<ClassTy> classTy){
        ClassTyVo classTyVo =new ClassTyVo();
        classTyVo.setPage(page);
        classTyVo.setClassTy(classTy);
        classTyVo.setTotal(total);
        classTyVo.setPageSize(pageSize);
        return classTyVo;
    }

    private List<ClassTy> classTy;
    private Long total;
}
