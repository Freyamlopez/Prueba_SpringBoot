package com.example.pruebaJordyHurtado.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor

public class OrderDto {
    private Long idClient;
    private List<Long> idsProducts;

}
