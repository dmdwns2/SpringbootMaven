package com.example.hello.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
@Configuration
public class DaoFactory {

    //H2
    @Bean
    UserDao H2UserDao(){
        return new UserDao(h2DataSource());
    }
    DataSource h2DataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .setName("likelion-db;MODE=MySQL")
                .addScript("classpath:jdbc/schema.sql")
                .build();
    }
}
