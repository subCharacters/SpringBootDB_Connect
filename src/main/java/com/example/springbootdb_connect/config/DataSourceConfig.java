package com.example.springbootdb_connect.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

// DB연동3
@Configuration
@MapperScan(value = "com.example.springbootdb_connect.mapper")
public class DataSourceConfig {

    @Value("${spring.datasource.mapper-location}")
    private String mapperPath;

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() throws Exception {
        return DataSourceBuilder
                .create()
                .build();
    }

    /**
     * MySql과 MyBatis를 연결해주는 객체생성
     *
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage("com.example.springbootdb_connect.entity");
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(mapperPath));

        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
