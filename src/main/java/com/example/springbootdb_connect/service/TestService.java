package com.example.springbootdb_connect.service;

import com.example.springbootdb_connect.dto.MembersDTO;
import com.example.springbootdb_connect.entity.Members;
import com.example.springbootdb_connect.repository.TestRepository;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private TestRepository testRepository;

    TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }
    public String getDate() {
        return "20231230";
    }

    public MembersDTO getMember(String username) {
        Members member = testRepository.findByUsername(username);
        MembersDTO membersDTO = MembersDTO.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .build();
        return membersDTO;
    }

    public MembersDTO selectByUsername(String username) {
        Members member = testRepository.findByUsername(username);
        MembersDTO membersDTO = MembersDTO.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .build();
        return membersDTO;
    }
}
