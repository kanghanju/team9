package com.example.team9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class Team9Application {

    public static void main(String[] args) {
        SpringApplication.run(Team9Application.class, args);
    }

}
