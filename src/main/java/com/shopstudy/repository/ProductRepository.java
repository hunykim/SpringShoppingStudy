package com.shopstudy.repository;

import com.shopstudy.domain.ProductDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ProductRepository {

    List<ProductDto> findAll();

    ProductDto findBy(long productId);

    void save(ProductDto product);

}
