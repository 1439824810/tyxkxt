package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.TeacherClassTy;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TeacherClassTyMapper {
//    对班级（teach_class）进行增删改查  4
//    SELECT * FROM teach_class WHERE tcid =292
//    INSERT INTO teach_class (cid,cname,tname,tgh,rsxz,xq,sqrade,sksd,sksq,isend,ssex,xkrs) VALUES(3,'排球','郝爽',1679,200,'1','2020','12','周四','0','0',0)
//    DELETE FROM teach_class WHERE tcid =291
//    UPDATE teach_class SET cid = 1008611,cname = 'ttt',tname ='nnnnnnn' ,tgh = 0,rsxz=1,xq = '0',sqrade='', sksd='',sksq='',isend='',ssex='',xkrs=1 WHERE tcid =292
    @Select("<script>SELECT * FROM teach_class where 1=1 <if test='cname != null and cname != \"\" '>and cname = #{cname}</if><if test='tname != null and tname != \"\" '>and tname = #{tname}</if><if test='xq != null and xq != \"\" '>and xq = #{xq}</if><if test='sqrade != null and sqrade != \"\" '>and sqrade = #{sqrade}</if><if test='sksd != null and sksd != \"\" '>and sksd = #{sksd}</if><if test='sksq != null and sksq != \"\" '>and sksq = #{sksq}</if></script>")
    public List<TeacherClassTy> selectAllTeacherClass (@Param("cname")String cname,@Param("tname")String tname,@Param("xq")String xq,@Param("sqrade")String sqrade,@Param("sksd")String sksd,@Param("sksq")String sksq);
    @Select("<script>SELECT * FROM teach_class where isend=1 <if test='cname != null and cname != \"\" '>and cname = #{cname}</if><if test='tname != null and tname != \"\" '>and tname = #{tname}</if><if test='xq != null and xq != \"\" '>and xq = #{xq}</if><if test='sqrade != null and sqrade != \"\" '>and sqrade = #{sqrade}</if><if test='sksd != null and sksd != \"\" '>and sksd = #{sksd}</if><if test='sksq != null and sksq != \"\" '>and sksq = #{sksq}</if></script>")
    public List<TeacherClassTy> selectAllTeacherClassNoIsend (@Param("cname")String cname,@Param("tname")String tname,@Param("xq")String xq,@Param("sqrade")String sqrade,@Param("sksd")String sksd,@Param("sksq")String sksq);
    @Select("SELECT DISTINCT sqrade FROM teach_class where sqrade!=\"\"")
    public List<TeacherClassTy> selectAllTeacherClassSqrade ();
    @Select("SELECT * FROM teach_class where cid=#{cid} and isend!=0")
    public List<TeacherClassTy> selectTeacherClassTybyCid (Integer cid);
    @Select("SELECT * FROM teach_class WHERE tcid =#{tcid}")
    public TeacherClassTy selectXkNum(Integer tcid);
    @Insert("INSERT INTO teach_class (cid,cname,tname,tgh,rsxz,xq,sqrade,sksd,sksq,isend,ssex,xkrs) VALUES(#{addTeacherClass.cid},#{addTeacherClass.cname},#{addTeacherClass.tname},#{addTeacherClass.tgh},#{addTeacherClass.rsxz},#{addTeacherClass.xq},#{addTeacherClass.sqrade},#{addTeacherClass.sksd},#{addTeacherClass.sksq},#{addTeacherClass.isend},#{addTeacherClass.ssex},#{addTeacherClass.xkrs})")
    public void addTeacherClass(@Param("addTeacherClass") TeacherClassTy addTeacherClass);
    @Delete("DELETE FROM teach_class WHERE tcid =#{tcid}")
    public void deleteTeacherClass(Integer tcid);
    @Update("UPDATE teach_class SET cid = #{updateTeacherClass.cid},cname = #{updateTeacherClass.cname},tname =#{updateTeacherClass.tname} ,tgh = #{updateTeacherClass.tgh},rsxz=#{updateTeacherClass.rsxz},xq = #{updateTeacherClass.xq},sqrade=#{updateTeacherClass.sqrade}, sksd=#{updateTeacherClass.sksd},sksq=#{updateTeacherClass.sksq},isend=#{updateTeacherClass.isend},ssex=#{updateTeacherClass.ssex},xkrs=#{updateTeacherClass.xkrs} WHERE tcid =#{updateTeacherClass.tcid}")
    public void updateTeacherClass(@Param("updateTeacherClass") TeacherClassTy updateTeacherClass);
//    UPDATE teach_class SET xkrs = xkrs+1 WHERE tcid = 264
    @Update("UPDATE teach_class SET xkrs=xkrs+1 WHERE tcid =#{updateTeacherClassAddNum}")
    public void updateTeacherClassAddNum(@Param("updateTeacherClassAddNum") Integer tcid);
    @Update("UPDATE teach_class SET isend=#{updateTeacherClass.isend} WHERE tcid =#{updateTeacherClass.tcid}")
    public void JieKe(@Param("updateTeacherClass") TeacherClassTy updateTeacherClass);
    @Select("SELECT DISTINCT sqrade FROM teach_class ORDER BY sqrade")
    public List<String> getLastXkTime();
    @Select("SELECT tc.isend, tc.tcid, tc.cname,tc.tname,tc.sksq,tc.sksd,tc.sqrade FROM teach_class tc,xk ,stu s WHERE tc.tcid = xk.tcid AND xk.sno=s.sno AND s.sno =#{sno}")
    public List<TeacherClassTy> getXkInfo( String  sno);
}
