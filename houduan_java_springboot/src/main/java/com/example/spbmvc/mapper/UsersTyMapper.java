package com.example.spbmvc.mapper;

import com.example.spbmvc.pojo.UsersTy;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersTyMapper {
//    对权限（user）进行增删改查  4
//    SELECT * FROM users
//    SELECT * FROM users where tgh = 1
//    INSERT INTO users (tgh,tname,pwd,jurisdiction) VALUES(10086,'yuyang','123241',100)
//    DELETE FROM users WHERE tgh =10086
//    UPDATE users SET tgh = 10086,tname = 'yuyang',pwd ='nnnnnnn' ,jurisdiction=0 WHERE tgh =10086
    @Select("<script>SELECT * FROM users where 1=1 <if test='tgh != null and tgh != \"\" '>and tgh = #{tgh}</if><if test='jurisdiction != null and jurisdiction != \"\" '>and jurisdiction &lt;=  #{jurisdiction}</if></script>")
    public List<UsersTy> usersSelectAll(@Param("tgh")Integer tgh,@Param("jurisdiction")Integer jurisdiction);
    @Delete("DELETE FROM users WHERE tgh =#{tgh}")
    public void usersDeleteByTgh(Integer tgh);
    @Insert("INSERT INTO users (tgh,tname,pwd,jurisdiction) VALUES(#{addUsers.tgh},#{addUsers.tname},#{addUsers.pwd},#{addUsers.jurisdiction})")
    public void addUsers(@Param("addUsers") UsersTy addUsers);
    @Update("UPDATE users SET tgh = #{upadtUsers.tgh},tname =#{upadtUsers.tname},pwd =#{upadtUsers.pwd} ,jurisdiction = #{upadtUsers.jurisdiction} WHERE tgh =#{upadtUsers.tgh}")
    public void upadtUsers(@Param("upadtUsers") UsersTy upadtUsers);
//    @Update("<script>UPDATE users SET tgh = #{upadtUsers.tgh},tname =#{upadtUsers.tname}<if test='pwd != null and pwd != \"\" '>,pwd =#{upadtUsers.pwd}</if> <if test='jurisdiction != null and jurisdiction != \"\" '>,jurisdiction = #{upadtUsers.jurisdiction}</if> WHERE tgh =#{upadtUsers.tgh}</script>")
//    public void upadtUsers(@Param("upadtUsers") UsersTy upadtUsers);
}
