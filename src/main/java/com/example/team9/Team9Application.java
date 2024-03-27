package com.example.team9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // created_date, updated_date 자동 업데이트
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Team9Application {

    public static void main(String[] args) {
        SpringApplication.run(Team9Application.class, args);
    }

}
