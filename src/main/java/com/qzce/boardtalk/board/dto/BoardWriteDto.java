package com.qzce.boardtalk.board.dto;

import com.qzce.boardtalk.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardWriteDto {

    private Long bid;
    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                        .bid(bid)
                        .title(title)
                        .content(content)
                        .build();
    }

}
