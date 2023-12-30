# SpringBootDB_Connect

Members생성 쿼리
CREATE TABLE Members (
user_id BIGINT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) UNIQUE,
password VARCHAR(100),
nickname VARCHAR(50),
created_at DATETIME NOT NULL,
updated_at DATETIME
);


import쿼리
INSERT INTO Members (username, password, nickname, created_at, updated_at)
VALUES ('testuser', 'test1234', 'tests', NOW(), NOW());
