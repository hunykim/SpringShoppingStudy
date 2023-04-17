package com.shopstudy.repository;

import com.shopstudy.domain.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardRepository {

    void save(BoardDto boardDto);

    List<BoardDto> findBy(String email);

    List<BoardDto> listAll();

    void delete(long boardId);

    void update(BoardDto boardDto);


}
