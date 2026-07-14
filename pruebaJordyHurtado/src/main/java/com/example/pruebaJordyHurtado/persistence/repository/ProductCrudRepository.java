package com.example.pruebaJordyHurtado.persistence.repository;

import com.example.pruebaJordyHurtado.persistence.entity.ProductEntity;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductCrudRepository extends ListCrudRepository <ProductEntity, Long>{

    List<ProductEntity> findByDisponibleTrue();

}
