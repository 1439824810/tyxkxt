package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.TeacherTy;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface TeacherTyMapper {
//    对教师（teacher）进行增删改查  4
//    SELECT * FROM teacher
//    INSERT INTO teacher (tgh,tname,tsex,tinfo,tdept,retired) VALUES(10086,'test','nvv','','tyb','1')
//    DELETE FROM teacher WHERE tgh =10086
//    UPDATE teacher SET tgh = 1008611,tname = 'ttttssss',tsex ='nnnnnnn' ,tinfo = '0',tdept='aaaaaaaaaaa',retired = '0' WHERE tgh =10086
    @Select("<script>SELECT * FROM teacher where 1=1 <if test='tgh != null and tgh != \"\" '>and tgh = #{tgh}</if><if test='tname != null and tname != \"\" '>and tname = #{tname}</if><if test='retired != null and retired != \"\" '>and retired != #{retired}</if></script>")
    public List<TeacherTy> teacherSelectAll(@Param("tgh")Integer tgh,@Param("tname")String tname,@Param("retired")String retired);
    //    根据tgh删除
    @Delete("DELETE FROM teacher WHERE tgh =#{tgh}")
    public void deleteByTgh(Integer tgh);
    //    添加教师
    @Insert("INSERT INTO teacher (tgh,tname,tsex,tinfo,tdept,retired) VALUES(#{addTeacher.tgh},#{addTeacher.tname},#{addTeacher.tsex},#{addTeacher.tinfo},#{addTeacher.tdept},#{addTeacher.retired})")
    public void addTeacher(@Param("addTeacher") TeacherTy addTeacher);
    //    修改教师
    @Update("UPDATE teacher SET tgh = #{upadtTeacher.tgh},tname =#{upadtTeacher.tname},tsex =#{upadtTeacher.tsex} ,tinfo = #{upadtTeacher.tinfo},tdept = #{upadtTeacher.tdept},retired = #{upadtTeacher.retired} WHERE tgh =#{upadtTeacher.tgh}")
    public void upadtTeacher(@Param("upadtTeacher") TeacherTy upadtTeacher);
}
