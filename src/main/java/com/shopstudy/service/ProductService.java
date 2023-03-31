package com.shopstudy.service;

import com.shopstudy.domain.ProductDto;
import com.shopstudy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> productList() {
        return productRepository.findAll();
    }

    public ProductDto productInfo(long productId) {
        return  productRepository.findBy(productId);
    }

    public void productSave(ProductDto product) {
        productRepository.save(product);
    }

}
