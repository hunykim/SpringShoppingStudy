package com.shopstudy.service;

import com.shopstudy.domain.OrderDto;
import com.shopstudy.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDto> orderList() {
        return  orderRepository.findAll();
    }

    public List<OrderDto> orderInfo(String userId) {
        return orderRepository.findBy(userId);
    }

    public void orderSave(OrderDto order) {
        orderRepository.save(order);
    }

    public void orderUpdate(OrderDto order) {
        orderRepository.update(order);
    }

}
