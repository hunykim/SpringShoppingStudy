package com.shopstudy.controller;

import com.shopstudy.domain.BoardDto;
import com.shopstudy.service.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @ApiOperation("Q&A게시판 전체 리스트")
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto>> boardList() {

        List<BoardDto> listAll = boardService.listAll();

        return new ResponseEntity<>(listAll, HttpStatus.OK);
    }

    @ApiOperation("Q&A게시판 조회")
    @GetMapping("/listByUser")
    public ResponseEntity<List<BoardDto>> boardByUser(String email) {
        List<BoardDto> listBy = boardService.listBy(email);

        return new ResponseEntity<>(listBy, HttpStatus.OK);
    }

    @ApiOperation("Q&A게시판 등록")
    @PostMapping("/insert")
    public ResponseEntity<?> insert(BoardDto boardDto) {

        boardService.save(boardDto);

       return ResponseEntity.ok().build();
    }

    @ApiOperation("Q&A게시판 삭제")
    @PostMapping("/delete")
    public ResponseEntity<?> delete(long boardId) {
        boardService.delete(boardId);

        return ResponseEntity.ok().build();
    }

    @ApiOperation("Q&A게시판 수정")
    @PostMapping("/update")
    public ResponseEntity<?> update(BoardDto boardDto) {
        boardService.update(boardDto);

        return ResponseEntity.ok().build();
    }

}
