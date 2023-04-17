package com.shopstudy.controller;

import com.shopstudy.domain.BoardDto;
import com.shopstudy.service.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @ApiOperation("Q&A게시판 전체 리스트")
    @GetMapping("/boardList")
    public ResponseEntity<List<BoardDto>> boardList() {

        List<BoardDto> listAll = boardService.listAll();

        return new ResponseEntity<>(listAll, HttpStatus.OK);
    }

    @ApiOperation("Q&A게시판 조회")
    @GetMapping("/boardListBy")
    public ResponseEntity<?> boardListBy(String email) {
        List<BoardDto> listBy = boardService.listBy(email);

        return new ResponseEntity<>(listBy, HttpStatus.OK);
    }

    @ApiOperation("Q&A게시판 등록")
    @PostMapping("/boardInsert")
    public ResponseEntity<?> boardInsert(BoardDto board) {

        boardService.save(board);

       return ResponseEntity.ok().build();
    }

    @ApiOperation("Q&A게시판 삭제")
    @PostMapping("/boardDelete")
    public ResponseEntity<?> boardDelete(long boardId) {
        boardService.delete(boardId);

        return ResponseEntity.ok().build();
    }



}
