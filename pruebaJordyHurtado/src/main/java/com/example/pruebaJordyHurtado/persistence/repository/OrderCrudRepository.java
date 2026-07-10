package com.example.pruebaJordyHurtado.persistence.repository;

import com.example.pruebaJordyHurtado.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface OrderCrudRepository extends ListCrudRepository<OrderEntity, Long> {
}
