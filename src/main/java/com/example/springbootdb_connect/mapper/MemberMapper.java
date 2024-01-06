package com.example.springbootdb_connect.mapper;

import com.example.springbootdb_connect.entity.Members;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberMapper {
    Members findByUsername(String username);

    @Select("SELECT * FROM MEMBERS WHERE USERNAME = #{username}")
    Members selectByUsername(String username);

    @Select("SELECT * FROM MEMBERS WHERE USERNAME = #{username}")
    @Results(value = {
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "nickname", property = "nickname")
    })
    Members selectByUsernameOnResults(String username);

    @Select("SELECT * FROM MEMBERS WHERE USERNAME = #{username}")
    @ResultMap("membersResultMap")
    Members selectByUsernameOnResultMap(String username);
}
