package com.example.pruebaJordyHurtado.web.controller;

import com.example.pruebaJordyHurtado.persistence.entity.OrderEntity;
import com.example.pruebaJordyHurtado.service.OrderService;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(this.orderService.getALL());
    }
}
