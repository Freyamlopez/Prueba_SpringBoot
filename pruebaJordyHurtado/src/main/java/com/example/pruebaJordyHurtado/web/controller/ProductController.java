package com.example.pruebaJordyHurtado.web.controller;

import com.example.pruebaJordyHurtado.persistence.entity.ProductEntity;
import com.example.pruebaJordyHurtado.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    public ResponseEntity<List<ProductEntity>> getAll(){
        return ResponseEntity.ok(this.productService.getAll());
    }

    public ResponseEntity<ProductEntity> save(ProductEntity product){
        return ResponseEntity.ok(this.productService.save(product));
    }

    public ResponseEntity<ProductEntity> getById(long id){
        return ResponseEntity.ok(this.productService.getById(id));
    }
}
