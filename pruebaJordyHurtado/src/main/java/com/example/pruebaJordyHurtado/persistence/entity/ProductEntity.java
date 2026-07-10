package com.example.pruebaJordyHurtado.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table (name="product")
public class ProductEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name="id_product")
    private Long idProduct;

    @Column (name = "name")
    private String nombre;

    @Column (name = "price")
    private Double precio;

    @Column (name = "available")
    private Boolean disponible;




}


