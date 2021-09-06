package com.example.spbmvc.vo;

import com.example.spbmvc.pojo.TeacherTy;

import java.util.List;

public class TeacherTyVo {
    private Integer page;
    private Integer pageSize;
    private List<TeacherTy> teacherTyList;
    private Long total;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public static TeacherTyVo data(Integer page, Integer pageSize, Long total, List<TeacherTy> teacherTyList){
        TeacherTyVo TeacherTyVo =new TeacherTyVo();
        TeacherTyVo.setPage(page);
        TeacherTyVo.setTeacherTyList(teacherTyList);

        TeacherTyVo.setPageSize(pageSize);
        TeacherTyVo.setTotal(total);

        return TeacherTyVo;
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

    public List<TeacherTy> getTeacherTyList() {
        return teacherTyList;
    }

    public void setTeacherTyList(List<TeacherTy> teacherTyList) {
        this.teacherTyList = teacherTyList;
    }
}
