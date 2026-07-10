package com.example.pruebaJordyHurtado.service;


import com.example.pruebaJordyHurtado.persistence.entity.ProductEntity;
import com.example.pruebaJordyHurtado.persistence.repository.ProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductCrudRepository productCrudRepository;

    @Autowired
    public ProductService(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }


    public List<ProductEntity> getAll(){
        return this.productCrudRepository.findAll();
    }


    public ProductEntity save(ProductEntity product){
        return this.productCrudRepository.save(product);
    }


    public ProductEntity getById (long id){
        return this.productCrudRepository.findById(id).orElse(null);
    }

}
