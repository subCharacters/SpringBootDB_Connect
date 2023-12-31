package com.example.springbootdb_connect.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Getter
@AllArgsConstructor
public class ResponseDTO<T> {

    private boolean success;
    private T data;
    private Error error;

    public static <T> ResponseEntity<ResponseDTO> success(T data) {
        return ResponseEntity.ok().body(new ResponseDTO(true, data, null));
    }

    public static <T> ResponseEntity<ResponseDTO> fail(HttpStatus httpStatus, T data) {
        return ResponseEntity.status(httpStatus).body(new ResponseDTO(false, data, new Error("E001", "Error")));
    }

    static class Error {
        private String errorCode;
        private String errorMessage;
        public Error(String errorCode, String errorMessage) {
        }
    }
}
