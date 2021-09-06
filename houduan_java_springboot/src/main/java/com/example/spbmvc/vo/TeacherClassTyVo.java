package com.example.spbmvc.vo;

import com.example.spbmvc.pojo.TeacherClassTy;

import java.util.List;

public class TeacherClassTyVo {
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

    public List<TeacherClassTy> getTeacherClassTyList() {
        return teacherClassTyList;
    }

    public void setTeacherClassTyList(List<TeacherClassTy> teacherClassTyList) {
        this.teacherClassTyList = teacherClassTyList;
    }
    private Long total;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    private List<TeacherClassTy> teacherClassTyList;


    public static TeacherClassTyVo data(Integer page, Integer pageSize, Long total, List<TeacherClassTy> teacherClassTIES){
        TeacherClassTyVo TeacherClassTyVo =new TeacherClassTyVo();
        TeacherClassTyVo.setPage(page);
        TeacherClassTyVo.setTeacherClassTyList(teacherClassTIES);
        TeacherClassTyVo.setTotal(total);
        TeacherClassTyVo.setPageSize(pageSize);

        return TeacherClassTyVo;
    }
}
