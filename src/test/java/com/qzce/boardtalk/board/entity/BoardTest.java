package com.qzce.boardtalk.board.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 외부 데이터베이스 연
public class BoardTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {

    }

    @Test
    public void title_빈값() {

        testEntityManager.persist(Board.builder()
                .title("testTitle")
                .content("testContent")
                .build());

        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new Board(13030L, null, "content"))
                .withMessage("title is empty");
    }

}
