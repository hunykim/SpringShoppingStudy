package com.shopstudy.controller;

import com.shopstudy.domain.BasketDto;
import com.shopstudy.service.BasketService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @ApiOperation(value = "장바구니 목록")
    @GetMapping("/basketList")
    public List<BasketDto> basketList(String userId) {
        return basketService.basketList(userId);
    }

    @ApiOperation(value = "장바구니 물건추가")
    @PostMapping("/basketSave")
    public void basketSave(BasketDto basket) {
        basketService.basketSave(basket);
    }

    @ApiOperation(value = "장바구니 물건삭제")
    @PostMapping("/basketDelete")
    public void basketDelete(long id) {
        basketService.basketDelete(id);
    }

}
