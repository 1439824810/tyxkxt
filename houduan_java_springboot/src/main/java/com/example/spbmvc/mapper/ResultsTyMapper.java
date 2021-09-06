package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.ResultsTy;
import com.example.spbmvc.pojo.ResultsTyLj;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResultsTyMapper {
//    对成绩（results）进行增改查  3
//    SELECT s.sname,s.ssex,s.sqrade,s.sclass,s.sxy,r.* FROM stu s left JOIN results r on s.sno = r.sno
//    SELECT * FROM results
//    INSERT INTO results (sno,zx1,zx2,tjq,xyp,pscj,zcj,tcid) VALUES('1810617103',100,100,100,100,100,100,5)
//    UPDATE results SET zx1=0,zx2=0,tjq=0,xyp=0,pscj=0,zcj=0 WHERE resid=16172
    @Select("<script>SELECT s.sname,s.ssex,s.sqrade,s.sclass,s.sxy,r.* FROM stu s left JOIN results r on s.sno = r.sno WHERE r.sno is not null <if test='sno != null and sno != \" \" '>and s.sno = #{sno}</if><if test='tcid != null and tcid != \" \" '>and r.tcid = #{tcid}</if></script>")
    public List<ResultsTyLj> selectAllResults(@Param("sno") String sno,@Param("tcid") Integer tcid);
    @Insert("INSERT INTO results (sno,zx1,zx2,tjq,xyp,pscj,zcj,tcid) VALUES(#{addResults.sno},#{addResults.zx1},#{addResults.zx2},#{addResults.tjq},#{addResults.xyp},#{addResults.pscj},#{addResults.zcj},#{addResults.tcid})")
    public void addResults(@Param("addResults") ResultsTy addResults);
    @Update("UPDATE results SET zx1=#{updateResults.zx1},zx2=#{updateResults.zx2},tjq=#{updateResults.tjq},xyp=#{updateResults.xyp},pscj=#{updateResults.pscj},zcj=#{updateResults.zcj} WHERE resid=#{updateResults.resid}")
    public void updateResults(@Param("updateResults") ResultsTy updateResults);

}
