package com.shopstudy.controller;

import com.shopstudy.domain.ReviewDto;
import com.shopstudy.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @ApiOperation(value = "리뷰목록")
    @GetMapping("/reviewList")
    public List<ReviewDto> reviewList(long productId) {
        return reviewService.reviewList(productId);
    }

    @ApiOperation(value = "리뷰등록")
    @PostMapping("/reviewSave")
    public void reviewSave(ReviewDto review) {
        reviewService.reviewSave(review);
    }

    @ApiOperation(value = "리뷰삭제")
    @PostMapping("/reviewDelete")
    public void reviewDelete(long id) {
        reviewService.reviewDelete(id);
    }

}
