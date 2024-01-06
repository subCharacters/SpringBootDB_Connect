package com.example.springbootdb_connect.service;

import com.example.springbootdb_connect.dto.MembersDTO;
import com.example.springbootdb_connect.entity.Members;
import com.example.springbootdb_connect.mapper.MemberMapper;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private MemberMapper memberMapper;

    TestService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }
    public String getDate() {
        return "20231230";
    }

    public MembersDTO getMember(String username) {
        Members member = memberMapper.findByUsername(username);
        MembersDTO membersDTO = MembersDTO.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .build();
        return membersDTO;
    }

    public MembersDTO selectByUsername(String username) {
        Members member = memberMapper.selectByUsername(username);
        MembersDTO membersDTO = MembersDTO.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .build();
        return membersDTO;
    }

    public MembersDTO selectByUsernameOnResults(String username) {
        Members member = memberMapper.selectByUsernameOnResults(username);
        MembersDTO membersDTO = MembersDTO.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .build();
        return membersDTO;
    }

    public MembersDTO selectByUsernameOnResultMap(String username) {
        Members member = memberMapper.selectByUsernameOnResultMap(username);
        MembersDTO membersDTO = MembersDTO.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .build();
        return membersDTO;
    }
}
