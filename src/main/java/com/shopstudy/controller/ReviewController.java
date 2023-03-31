package com.shopstudy.controller;

import com.shopstudy.domain.ReviewDto;
import com.shopstudy.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;


    @GetMapping("/reviewList")
    public List<ReviewDto> reviewList(long productId) {
        return reviewService.reviewList(productId);
    }

    @PostMapping("/reviewSave")
    public void reviewSave(ReviewDto review) {
        reviewService.reviewSave(review);
    }

    @PostMapping("/reviewDelete")
    public void reviewDelete(long id) {
        reviewService.reviewDelete(id);
    }

}
