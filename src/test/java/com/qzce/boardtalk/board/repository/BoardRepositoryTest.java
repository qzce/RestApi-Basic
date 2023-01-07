package com.qzce.boardtalk.board.repository;

import com.qzce.boardtalk.board.entity.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    private Board newBoard;
    private Long boardCount;

    @BeforeEach
    void setUp() {

        boardCount = boardRepository.count();

        newBoard = boardRepository.save(
                Board.builder().title("testTitle").content("testContent")
                        .build());
    }

    @Test
    void 게시글_조회() {
        Optional<Board> board = boardRepository.findById(newBoard.getBid());
        Assertions.assertEquals(board.get().getBid(), newBoard.getBid());
    }

    @Test
    void 게시글_저장() {

        // given
        String title = "titleTest2";
        String content = "contentTest";

        // when
        Board savedBoard = boardRepository.save(Board.builder()
                                                    .title(title)
                                                    .content(content)
                                                    .build());
        // then
        Board board = boardRepository.findById(savedBoard.getBid()).orElseThrow();

        Assertions.assertEquals(board.getTitle(), title);
        Assertions.assertEquals(board.getContent(), content);
    }

    @Test
    void 게시글_수정() {

        // given
        Long bid = newBoard.getBid();
        String title = "testTitle2";
        String content = "testContent2";

        // when
        Board updatedBoard = boardRepository.save(Board.builder()
                                                    .bid(bid)
                                                    .title(title)
                                                    .content(content)
                                                    .build());
        // then
        Board board = boardRepository.findById(updatedBoard.getBid()).orElseThrow();

        Assertions.assertEquals(newBoard.getBid(), board.getBid());
        Assertions.assertEquals(board.getTitle(), title);
        Assertions.assertEquals(board.getContent(), content);
    }

    @Test
    void 게시글_삭제() {

        // given
        Long bid = newBoard.getBid();

        // when
        boardRepository.deleteById(bid);

        // then
        Long deletedCount = boardRepository.count();

        Assertions.assertEquals(deletedCount, boardCount);

    }

}
