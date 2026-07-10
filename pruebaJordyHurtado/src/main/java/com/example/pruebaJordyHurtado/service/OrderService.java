
package com.example.pruebaJordyHurtado.service;


import com.example.pruebaJordyHurtado.persistence.entity.OrderEntity;
import com.example.pruebaJordyHurtado.persistence.repository.OrderCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderCrudRepository orderCrudRepository;

    @Autowired
    public OrderService(OrderCrudRepository orderCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
    }

    public List<OrderEntity> getALL (){
        return this.orderCrudRepository.findAll();
    }
}
