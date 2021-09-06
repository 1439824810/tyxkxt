package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.StuTy;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StuTyMapper {
//    对学生（stu）进行增删改查  4
//    SELECT * FROM stu WHERE sno ='1008611'
//    INSERT INTO stu (sno,sname,ssex,sqrade,sclass,sxy) VALUES('10086','test','nvv','2018','xg1801','jjglxy')
//    DELETE FROM stu WHERE sno =10086
//    UPDATE stu SET sno = '1008611',sname = 'ttttssss',ssex ='nnnnnnn' ,sqrade = '0000',sclass='xg1801',sxy = 'jjglxy' WHERE sno =10086
    @Select("<script>SELECT * FROM stu where 1=1 <if test='sname != null and sname != \"\" '>and sname = #{sname}</if><if test='sno != null and sno != \"\" '>and sno = #{sno}</if><if test='sxy != null and sxy != \"\" '>and sxy = #{sxy}</if><if test='sqrade != null and sqrade != \"\" '>and sqrade = #{sqrade}</if></script>")
    public List<StuTy> stuSelectAll(@Param("sname")String sname,@Param("sno")String sno,@Param("sxy")String sxy,@Param("sqrade")String sqrade);
    @Select("<script>SELECT stu.* from stu,xk WHERE stu.sno = xk.sno AND xk.tcid = #{tcid} </script>")
    public List<StuTy> stuSelectByTcid(@Param("tcid")Integer tcid);
    //    根据tgh删除
    @Delete("DELETE FROM stu WHERE sno =#{sno}")
    public void stuDeleteBySno(String sno);
    //    添加教师
    @Insert("INSERT INTO stu (sno,sname,ssex,sqrade,sclass,sxy) VALUES(#{addStu.sno},#{addStu.sname},#{addStu.ssex},#{addStu.sqrade},#{addStu.sclass},#{addStu.sxy})")
    public void addStu(@Param("addStu") StuTy addStu);
    //    修改教师
    @Update("UPDATE stu SET sno = #{upadtStu.sno},sname =#{upadtStu.sname},ssex =#{upadtStu.ssex} ,sqrade = #{upadtStu.sqrade},sclass = #{upadtStu.sclass},sxy = #{upadtStu.sxy} WHERE sno =#{upadtStu.sno}")
    public void upadtStu(@Param("upadtStu") StuTy upadtStu);
    @Insert("<script>" +
            "insert into stu (sno,sname,ssex,sqrade,sclass,sxy) " +
            "values " +
            "<foreach collection='StuList' item='stu' index='stu.sno' separator=','>" +
            "(#{stu.sno},#{stu.sname},#{stu.ssex},#{stu.sqrade},#{stu.sclass},#{stu.sxy})" +
            "</foreach>" +
            "</script>")
    public void AddStuList(@Param("StuList") List<StuTy> stuList);
}
