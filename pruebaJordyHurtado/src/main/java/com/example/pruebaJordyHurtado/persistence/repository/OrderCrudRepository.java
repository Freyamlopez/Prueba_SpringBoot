package com.example.pruebaJordyHurtado.persistence.repository;

import com.example.pruebaJordyHurtado.persistence.entity.OrderEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrderCrudRepository extends ListCrudRepository<OrderEntity, Long> {
    List<OrderEntity> findByClientId(Long idClient);
}
