package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.StuTeacherClassTyLj;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface StuTeacherClassTyLjMapper {
    @Select("SELECT s.sno,s.sname,tc.tcid,tc.tname,tc.sksd,tc.sksq FROM stu s,xk,teach_class tc WHERE s.sno =xk.sno AND tc.tcid = xk.tcid AND tc.sqrade = #{sqrade} AND s.sno = #{sno}")
    public StuTeacherClassTyLj getLastXkInfo(@Param("sqrade") String sqrade,@Param("sno") String sno);
}
