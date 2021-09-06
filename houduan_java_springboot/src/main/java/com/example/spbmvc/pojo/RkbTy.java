package com.example.spbmvc.pojo;

public class RkbTy {
    public Integer getId() {
        return id;
}

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTgh() {
        return tgh;
    }

    public void setTgh(Integer tgh) {
        this.tgh = tgh;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    private Integer id;//任课ID
    private Integer tgh;//教师工号
    private Integer cid;//课程号
}
