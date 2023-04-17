package com.shopstudy.service;

import com.shopstudy.domain.BoardDto;
import com.shopstudy.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(BoardDto boardDto) {
        boardRepository.save(boardDto);
    }

    public List<BoardDto> listBy(String email) {
        return boardRepository.findBy(email);
    }

    public List<BoardDto> listAll() {
        return boardRepository.listAll();
    }

    public void delete(long boardId) {
        boardRepository.delete(boardId);
    }

    public void update(BoardDto boardDto) {
        boardRepository.update(boardDto);
    }

}
