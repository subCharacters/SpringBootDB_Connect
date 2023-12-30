package com.example.springbootdb_connect.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MembersDTO {

    private Long userId;
    private String username;
    private String password;
    private String nickname;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 생성자는 private로 설정하여 외부에서 직접 객체 생성을 방지
    private MembersDTO() {
    }

    public static MembersDTOBuilder builder() {
        return new MembersDTOBuilder();
    }

    public static class MembersDTOBuilder {
        private Long userId;
        private String username;
        private String password;
        private String nickname;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private MembersDTOBuilder() {
        }

        public MembersDTOBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public MembersDTOBuilder username(String username) {
            this.username = username;
            return this;
        }

        public MembersDTOBuilder password(String password) {
            this.password = password;
            return this;
        }

        public MembersDTOBuilder nickname(String nickname) {
            this.nickname = nickname;
            return this;
        }

        public MembersDTOBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public MembersDTOBuilder updatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public MembersDTO build() {
            MembersDTO membersDTO = new MembersDTO();
            membersDTO.userId = this.userId;
            membersDTO.username = this.username;
            membersDTO.password = this.password;
            membersDTO.nickname = this.nickname;
            membersDTO.createdAt = this.createdAt;
            membersDTO.updatedAt = this.updatedAt;
            return membersDTO;
        }
    }
}
