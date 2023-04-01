package com.shopstudy.repository;

import com.shopstudy.domain.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AdminRepository {

    List<UserDto> findAll();

    Integer getListCount();

    List<UserDto> listByDay(String startDt, String endDt);

    List<Map<String, Object>> salesByDay();

    List<Map<String, Object>> salesByMonth(String month);

    List<Map<String, Object>> salesByYear(String year);


}
