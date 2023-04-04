package com.shopstudy.repository;

import com.shopstudy.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    List<UserDto> findAll();

    Integer getListCount();

    void save(UserDto user);

    UserDto findBy(long id);

    UserDto userIdChk(String email);

    UserDto loginChk(UserDto user);

    Optional<UserDto> findByUserId(String userId);

}
