package com.example.pruebaJordyHurtado.persistence.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name= "client")
public class ClientEntity {

    @Id
    private Long id;

    @Column (name="name")
    private String nombre;

    @Column (name = "email")
    private  String correo;


    @Column(name="phone")
    private String telefono;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderEntity> orders;



}

