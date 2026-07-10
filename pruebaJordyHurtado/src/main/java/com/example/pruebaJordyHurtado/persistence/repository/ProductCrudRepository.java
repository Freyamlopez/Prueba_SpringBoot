package com.example.pruebaJordyHurtado.persistence.repository;

import com.example.pruebaJordyHurtado.persistence.entity.ProductEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductCrudRepository extends ListCrudRepository <ProductEntity, Long>{
}
