package com.example.springbootdb_connect.controller;

import com.example.springbootdb_connect.dto.MembersDTO;
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
    public ResponseEntity<Map<String, String>> getDate() {
        Map result = new HashMap<String, String>();
        String now = testService.getDate();
        result.put("Date", now);
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value = "/get-memberinfo", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<MembersDTO> getMemberInfo(@RequestParam String username) {
        return ResponseEntity.ok().body(testService.getMember(username));
    }
}
