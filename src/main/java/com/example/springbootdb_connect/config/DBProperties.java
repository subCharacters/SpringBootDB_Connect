package com.example.springbootdb_connect.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

// DB연동2
@Component
@Getter
@Setter
// 아래와 같이 사용 가능하나 properties만 되고 yml은 안된다.
// @PropertySource("classpath:/db.properties")
public class DBProperties {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.driverClassName}")
    private String driverClassName;

    // log 출력
    @PostConstruct
    public void init() {
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
        System.out.println(driverClassName);
    }

    @Bean
    public DataSource datasource() {
        return DataSourceBuilder.create()
                .url(url)
                .username(username)
                .password(password)
                .driverClassName(driverClassName)
                .build();
    }
}
