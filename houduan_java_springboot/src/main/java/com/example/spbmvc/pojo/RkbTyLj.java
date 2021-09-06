package com.example.spbmvc.pojo;

public class RkbTyLj {
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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    //    教师教哪科（rkb）的增删改查   4
//    SELECT r.Id,t.tgh,t.tname,c.cid,c.cname FROM rkb r,class c,teacher t WHERE r.cid=c.cid AND t.tgh =r.tgh AND r.tgh = 1178
//    INSERT INTO rkb (tgh,cid) VALUES(1178,4)
//    DELETE FROM rkb WHERE id =59
//    UPDATE rkb SET tgh = 1178,cid = 5 WHERE id =59
    private Integer id;
    private Integer tgh;
    private String tname;
    private Integer cid;
    private String cname;

}
