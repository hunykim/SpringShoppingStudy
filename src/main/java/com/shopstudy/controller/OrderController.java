package com.shopstudy.controller;

import com.shopstudy.domain.OrderDto;
import com.shopstudy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/orderList")
    public List<OrderDto> orderList() {
        return orderService.orderList();
    }

    @GetMapping("/orderInfo")
    public List<OrderDto> orderInfo(String userId) {
        return orderService.orderInfo(userId);
    }

    @PostMapping("/orderSave")
    public void orderSave(OrderDto order) {
        orderService.orderSave(order);
    }

    @PostMapping("/orderUpdate")
    public void orderUpdate(OrderDto order) {
        orderService.orderUpdate(order);
    }


}
