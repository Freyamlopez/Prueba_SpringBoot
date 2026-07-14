package com.example.pruebaJordyHurtado.web.controller;

import com.example.pruebaJordyHurtado.persistence.entity.ProductEntity;
import com.example.pruebaJordyHurtado.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;


    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAll(){
        return ResponseEntity.ok(this.productService.getAll());
    }


    @PostMapping
    public ResponseEntity<ProductEntity> save(@RequestBody ProductEntity product){
        return ResponseEntity.ok(this.productService.save(product));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ProductEntity> getById(@PathVariable long id){
        return ResponseEntity.ok(this.productService.getById(id));
    }

    @GetMapping ("/available")
    public ResponseEntity<List<ProductEntity>> findDisponible (){
        return ResponseEntity.ok(this.productService.getAvailableProducts());
    }


    @PutMapping ("/{idProduct}/disponible")
    public ResponseEntity<ProductEntity> updateAvailable(@PathVariable Long idProduct, @RequestParam Boolean disponible) {
        ProductEntity updatedProduct = this.productService.updateAvailable(idProduct, disponible);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }
}



