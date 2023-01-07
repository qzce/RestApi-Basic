package com.qzce.boardtalk.board.controller;

import com.qzce.boardtalk.board.dto.BoardWriteDto;
import com.qzce.boardtalk.board.entity.Board;
import com.qzce.boardtalk.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity boardAll(@PageableDefault(size=5, sort = "bid") Pageable pageable) {

        Page<Board> list = boardService.boardList(pageable);

        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/{bid}")
    public ResponseEntity boardDetail(@PathVariable("bid") Long bid) {

        Board board = boardService.boardView(bid);

        return new ResponseEntity(board, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity boardWrite(@RequestBody BoardWriteDto boardWriteDto) {

        Board board = boardService.boardSave(boardWriteDto);

        return new ResponseEntity(board, HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity boardUpdate(@RequestBody BoardWriteDto boardWriteDto) {

        Board board = boardService.boardSave(boardWriteDto);

        return new ResponseEntity(board, HttpStatus.OK);
    }

    @DeleteMapping("/{bid}")
    public ResponseEntity boardDelete(@PathVariable("bid") Long bid) {

        boardService.boardDelete(bid);

        return new ResponseEntity("Delete post" ,HttpStatus.OK);
    }

}
