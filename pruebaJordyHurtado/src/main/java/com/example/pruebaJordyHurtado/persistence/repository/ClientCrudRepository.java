package com.example.pruebaJordyHurtado.persistence.repository;

import com.example.pruebaJordyHurtado.persistence.entity.ClientEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface ClientCrudRepository extends ListCrudRepository <ClientEntity, Long> {
}
