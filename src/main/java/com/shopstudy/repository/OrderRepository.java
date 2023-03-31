package com.shopstudy.repository;

import com.shopstudy.domain.OrderDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface OrderRepository {

    List<OrderDto> findAll();

    List<OrderDto> findBy(String userId);

    void save(OrderDto order);

    void update(OrderDto order);
}
