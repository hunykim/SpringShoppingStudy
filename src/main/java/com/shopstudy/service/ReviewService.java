package com.shopstudy.service;

import com.shopstudy.domain.ReviewDto;
import com.shopstudy.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewDto> reviewList(long productId) {
        return reviewRepository.findBy(productId);
    }

    public void reviewSave(ReviewDto review) {
        reviewRepository.save(review);
    }

    public void reviewUpdate(ReviewDto review) {
        reviewRepository.update(review);
    }

    public void reviewDelete(long id) {
        reviewRepository.delete(id);
    }


}
