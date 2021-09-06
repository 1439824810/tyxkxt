package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.XkTy;
import com.example.spbmvc.pojo.XkTyLj;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface XkTyMapper {
//    对选课（xk  在班级里进行增删改查）进行增删改查  4
//    SELECT x.xkid,s.sno,s.sname,tc.* FROM xk x,teach_class tc,stu s,teacher t WHERE x.tcid=tc.tcid AND s.sno=x.sno AND t.tgh = tc.tgh AND x.sno = '1810617103'
//    INSERT INTO xk (tcid,sno) VALUES(96,'1810617103')
//    DELETE FROM xk WHERE xkid = 4087
//    UPDATE xk SET tcid = 97,sno = '1810617103' WHERE xkid = 4087
    @Select("<script>SELECT x.xkid,s.sno,s.sname,tc.* FROM xk x,teach_class tc,stu s,teacher t WHERE x.tcid=tc.tcid AND s.sno=x.sno AND t.tgh = tc.tgh<if test='sno != null and sno != \"\" '>and s.sno = #{sno}</if><if test='cname != null and cname != \"\" '>and tc.cname = #{cname}</if><if test='tname != null and tname != \"\" '>and tc.tname = #{tname}</if><if test='xq != null and xq != \"\" '>and tc.xq = #{xq}</if><if test='sqrade != null and sqrade != \"\" '>and tc.sqrade = #{sqrade}</if><if test='sksd != null and sksd != \"\" '>and tc.sksd = #{sksd}</if><if test='sksq != null and sksq != \"\" '>and tc.sksq = #{sksq}</if></script>")
    public List<XkTyLj> selectAllXk(@Param("sno") String sno,@Param("cname") String cname, @Param("tname") String tname,@Param("xq") String xq,@Param("sqrade") String sqrade,@Param("sksd") String sksd,@Param("sksq") String sksq);
    @Insert("INSERT INTO xk (tcid,sno) VALUES(#{addXk.tcid},#{addXk.sno})")
    public void addXk(@Param("addXk") XkTyLj addXk);
    @Delete("DELETE FROM xk WHERE sno = #{deleteXk.sno} and tcid =#{deleteXk.tcid}")
    public void deleteXk(@Param("deleteXk")XkTyLj deleteXk);
    @Update("UPDATE xk SET tcid = #{updateXk.tcid},sno =#{updateXk.sno} WHERE xkid = #{updateXk.xkid}")
    public void updateXk(@Param("updateXk")XkTyLj updateXk);
//    学生重复年度选课
//    @Select("SELECT count(*) FROM stu,xk,teach_class WHERE stu.sno =#{countXk.sno} AND stu.sno = xk.sno AND teach_class.tcid =xk.tcid AND teach_class.sqrade in (SELECT teach_class.sqrade  FROM stu,teach_class,xk WHERE  teach_class.tcid =  #{countXk.tcid} AND stu.sno =xk.sno AND teach_class.tcid = xk.tcid)")
    @Select("SELECT count(*) FROM (SELECT stu.sno,teach_class.sqrade FROM stu,xk,teach_class WHERE stu.sno =#{countXk.sno} AND stu.sno = xk.sno AND teach_class.tcid =xk.tcid) sq WHERE sqrade IN (SELECT sqrade  FROM teach_class WHERE tcid = #{countXk.tcid})")
    public  Integer countXk(@Param("countXk")XkTyLj xkTyLj);
//    选课人数
    @Select("SELECT COUNT(*) FROM xk WHERE tcid = #{tcid}")
    public Integer countBKNum(Integer tcid);
}
