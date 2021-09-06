package com.example.spbmvc.vo;

import com.example.spbmvc.pojo.UsersTy;

import java.util.List;

public class UserTyVo {
    private Integer page;
    private Integer pageSize;


    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public static UserTyVo data(Integer page, Integer pageSize, Long total, List<UsersTy> usersTyList){
        UserTyVo UserTyVo =new UserTyVo();
        UserTyVo.setPage(page);
        UserTyVo.setUsersTyList(usersTyList);
        UserTyVo.setPageSize(pageSize);

        UserTyVo.setTotal(total);


        return UserTyVo;
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

    public List<UsersTy> getUsersTyList() {
        return usersTyList;
    }

    public void setUsersTyList(List<UsersTy> usersTyList) {
        this.usersTyList = usersTyList;
    }

    private List<UsersTy> usersTyList;
    private Long total;
}
