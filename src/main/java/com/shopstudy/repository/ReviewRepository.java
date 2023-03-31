package com.shopstudy.repository;

import com.shopstudy.domain.ReviewDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ReviewRepository {

    List<ReviewDto> findBy(long productId);

    void save(ReviewDto review);

    void update(ReviewDto review);

    void delete(long id);

}
