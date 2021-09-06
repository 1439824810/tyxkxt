package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.RkbTy;
import com.example.spbmvc.pojo.RkbTyLj;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RkbTyLjMapper {
    //    教师教哪科（rkb）的增删改查   4
//    SELECT r.Id,t.tgh,t.tname,c.cid,c.cname FROM rkb r,class c,teacher t WHERE r.cid=c.cid AND t.tgh =r.tgh AND r.tgh = 1178
//    INSERT INTO rkb (tgh,cid) VALUES(1178,4)
//    DELETE FROM rkb WHERE id =59
//    UPDATE rkb SET tgh = 1178,cid = 5 WHERE id =59
    @Select("<script>SELECT r.Id,t.tgh,t.tname,c.cid,c.cname FROM rkb r,class c,teacher t WHERE r.cid=c.cid AND t.tgh =r.tgh<if test='tname != null and tname != \" \" '>and t.tname = #{tname}</if><if test='tgh != null and tgh != \" \" '>and t.tgh = #{tgh}</if><if test='cname != null and cname != \" \" '>and c.cname = #{cname}</if></script>")
    public List<RkbTyLj> selectAllRkbTyLj (@Param("tgh") Integer tgh,@Param("tname") String tname,@Param("cname") String cname);
    @Insert("INSERT INTO rkb (tgh,cid) VALUES(#{addRkbTy.tgh},#{addRkbTy.cid})")
    public void addRkbTy(@Param("addRkbTy") RkbTy addRkbTy);
    @Delete("DELETE FROM rkb WHERE id =#{id}")
    public void deleteRkbTy(Integer id);
    @Update("UPDATE rkb SET tgh = #{updateRkbTy.tgh},cid = #{updateRkbTy.cid} WHERE id =#{updateRkbTy.id}")
    public void updateRkbTy(@Param("updateRkbTy") RkbTy updateRkbTy);

}
