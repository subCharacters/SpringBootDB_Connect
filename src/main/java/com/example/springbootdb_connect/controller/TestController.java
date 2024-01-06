package com.example.springbootdb_connect.controller;

import com.example.springbootdb_connect.dto.MembersDTO;
import com.example.springbootdb_connect.dto.ResponseDTO;
import com.example.springbootdb_connect.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    private TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/get-date")
    public ResponseEntity<ResponseDTO> getDate() {
        String now = testService.getDate();
        return ResponseDTO.success(now);
    }

    @GetMapping(value = "/get-memberinfo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> getMemberInfo(@RequestParam String username) {
        return ResponseDTO.success(testService.getMember(username));
    }

    @GetMapping(value = "/selectByUsername", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> selectByUsername(@RequestParam String username) {
        return ResponseDTO.success(testService.selectByUsername(username));
    }

    @GetMapping(value = "/selectByUsernameOnResults", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> selectByUsernameOnResults(@RequestParam String username) {
        return ResponseDTO.success(testService.selectByUsernameOnResults(username));
    }

    @GetMapping(value = "/selectByUsernameOnResultMap", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ResponseDTO> selectByUsernameOnResultMap(@RequestParam String username) {
        return ResponseDTO.success(testService.selectByUsernameOnResultMap(username));
    }
}
