package com.example.springbootdb_connect.mapper;

import com.example.springbootdb_connect.entity.Members;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    Members findByUsername(String username);
}
