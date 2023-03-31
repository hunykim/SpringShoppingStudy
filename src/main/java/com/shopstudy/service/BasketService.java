package com.shopstudy.service;

import com.shopstudy.domain.BasketDto;
import com.shopstudy.repository.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketRepository basketRepository;

    public List<BasketDto> basketList(String userId) {
        return basketRepository.findBy(userId);
    }

    public void basketSave(BasketDto basket) {
        basketRepository.save(basket);
    }

    public void basketDelete(long id) {
        basketRepository.delete(id);
    }
}
