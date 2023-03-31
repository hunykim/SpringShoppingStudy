package com.shopstudy.repository;

import com.shopstudy.domain.BasketDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface BasketRepository {

    List<BasketDto> findBy(String userId);

    void save(BasketDto basket);

    void delete(long id);


}
