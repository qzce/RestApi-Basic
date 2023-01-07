package com.qzce.boardtalk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BoardTalkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardTalkApplication.class, args);
    }

}
