package com.shopstudy.controller;

import com.shopstudy.domain.OrderDto;
import com.shopstudy.service.OrderService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ApiOperation(value = "총주문내역")
    @GetMapping("/orderList")
    public List<OrderDto> orderList() {
        return orderService.orderList();
    }

    @ApiOperation(value = "해당 아이디 주문조회")
    @GetMapping("/orderInfo")
    public List<OrderDto> orderInfo(String userId) {
        return orderService.orderInfo(userId);
    }

    @ApiOperation(value = "주문내역추가")
    @PostMapping("/orderSave")
    public void orderSave(OrderDto order) {
        orderService.orderSave(order);
    }

    @ApiOperation(value = "주문 배송상태 변경")
    @PostMapping("/orderUpdate")
    public void orderUpdate(OrderDto order) {
        orderService.orderUpdate(order);
    }


}
