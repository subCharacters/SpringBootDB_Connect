package com.example.springbootdb_connect.service;

import com.example.springbootdb_connect.dto.MembersDTO;
import com.example.springbootdb_connect.entity.Members;
import com.example.springbootdb_connect.mapper.MemberMapper;
import com.example.springbootdb_connect.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private TestRepository testRepository;
    private MemberMapper memberMapper;

    TestService(TestRepository testRepository, MemberMapper memberMapper) {
        this.testRepository = testRepository;
        this.memberMapper = memberMapper;
    }
    public String getDate() {
        return "20231230";
    }

//    public MembersDTO getMember(String username) {
//        Members member = testRepository.findByUsername(username);
//        MembersDTO membersDTO = MembersDTO.builder()
//                .username(member.getUsername())
//                .password(member.getPassword())
//                .nickname(member.getNickname())
//                .build();
//        return membersDTO;
//    }

    public MembersDTO getMember(String username) {
        Members member = memberMapper.findByUsername(username);
        MembersDTO membersDTO = MembersDTO.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .build();
        return membersDTO;
    }
}
