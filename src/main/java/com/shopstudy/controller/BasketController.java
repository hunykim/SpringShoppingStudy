package com.shopstudy.controller;

import com.shopstudy.domain.BasketDto;
import com.shopstudy.service.BasketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping("/basketList")
    public List<BasketDto> basketList(String userId) {
        return basketService.basketList(userId);
    }

    @PostMapping("/basketSave")
    public void basketSave(BasketDto basket) {
        basketService.basketSave(basket);
    }

    @PostMapping("/basketDelete")
    public void basketDelete(long id) {
        basketService.basketDelete(id);
    }

}
