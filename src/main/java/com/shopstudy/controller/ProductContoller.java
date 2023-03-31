package com.shopstudy.controller;

import com.shopstudy.domain.ProductDto;
import com.shopstudy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ProductContoller {

    private final ProductService productService;

    @GetMapping("/productList")
    public List<ProductDto> productList() {
        return productService.productList();
    }

    @GetMapping("/productInfo")
    public ProductDto productInfo(long productId) {
        return productService.productInfo(productId);
    }

    @PostMapping("/productSave")
    public String productSave(ProductDto product, @RequestPart MultipartFile file) {

        String originalFileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String saveFileName = "C:/testFile/" + originalFileName;

        File saveFile = new File("C:/testFile/" + originalFileName);


        try {
            file.transferTo(saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        product.setPhoto(saveFileName);
        productService.productSave(product);

        return "saveOk";

    }



}
