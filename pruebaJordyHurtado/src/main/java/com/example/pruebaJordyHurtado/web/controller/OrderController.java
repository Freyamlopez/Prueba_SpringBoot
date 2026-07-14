package com.example.pruebaJordyHurtado.web.controller;

import com.example.pruebaJordyHurtado.persistence.entity.ClientEntity;
import com.example.pruebaJordyHurtado.persistence.entity.OrderEntity;
import com.example.pruebaJordyHurtado.service.OrderService;
import com.example.pruebaJordyHurtado.web.dto.OrderDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll(){
        return ResponseEntity.ok(this.orderService.getALL());
    }


    @PostMapping
    public ResponseEntity<OrderEntity> createOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.save(orderDto));

    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<OrderEntity>> getOrderClient(@PathVariable Long idClient){

        return ResponseEntity.ok(orderService.getByClient(idClient));

    }


}
