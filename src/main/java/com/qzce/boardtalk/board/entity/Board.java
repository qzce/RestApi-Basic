package com.qzce.boardtalk.board.entity;

import com.qzce.boardtalk.board.dto.BoardWriteDto;
import com.qzce.boardtalk.domain.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Builder
    public Board(Long bid, String title, String content) {
        this.bid = bid;
        this.title = title;
        this.content = content;
    }


}
