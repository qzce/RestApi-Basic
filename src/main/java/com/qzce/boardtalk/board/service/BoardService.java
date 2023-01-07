package com.qzce.boardtalk.board.service;

import com.qzce.boardtalk.board.dto.BoardWriteDto;
import com.qzce.boardtalk.board.entity.Board;
import com.qzce.boardtalk.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board boardView(Long bid) {
        return boardRepository.findById(bid)
                .orElseThrow(IllegalAccessError::new);
    }

    @Transactional
    public Board boardSave(BoardWriteDto boardWriteDto) {
        return boardRepository.save(boardWriteDto.toEntity());
    }

    @Transactional
    public void boardDelete(Long bid) {
        boardRepository.deleteById(bid);

    }


}
