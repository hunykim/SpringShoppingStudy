package com.shopstudy.repository;

import com.shopstudy.domain.UserDto;
import com.shopstudy.domain.UserLoginDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface UserRepository {

    void save(UserDto user);

    UserDto findBy(long id);

    UserDto userIdChk(String email);

    UserDto loginChk(UserLoginDto user);

    Optional<UserDto> findByUserId(String email);

}
