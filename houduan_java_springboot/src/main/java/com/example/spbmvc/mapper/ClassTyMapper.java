package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.ClassTy;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassTyMapper {
//    对课程（class）进行增删改查  4
//    SELECT * FROM class
//    INSERT INTO class (cname,cscope,cinfo,islife) VALUES('test',1,'test',1)
//    DELETE FROM class WHERE cid =21
//    UPDATE class SET cname = 'cname',cscope = '2',cinfo ='cinfo' ,islife = '0' WHERE cid =22
//    查询所有课程
    @Select("<script>SELECT * FROM class where 1=1 <if test='cname != null and cname != \"\" '>and cname = #{cname}</if></script>")
    public List<ClassTy> classSelectAll(@Param("cname")String cname);
//    根据cid删除
    @Delete("DELETE FROM class WHERE cid =#{cid}")
    public void deleteByCid(Integer cid);
//    添加课程
    @Insert("INSERT INTO class (cname,cscope,cinfo,islife) VALUES(#{addClass.cname},#{addClass.cscope},#{addClass.cinfo},#{addClass.islife})")
    public void addClass(@Param("addClass") ClassTy addClass);
//    修改课程
    @Update("UPDATE class SET cname = #{upadteClass.cname},cscope =#{upadteClass.cscope},cinfo =#{upadteClass.cinfo} ,islife = #{upadteClass.islife} WHERE cid =#{upadteClass.cid}")
    public void upadteClass(@Param("upadteClass") ClassTy upadteClass);

}
