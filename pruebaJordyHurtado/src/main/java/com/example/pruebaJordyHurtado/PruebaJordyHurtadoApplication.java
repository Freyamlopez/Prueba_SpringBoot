package com.example.pruebaJordyHurtado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EnableJpaRepositories
public class PruebaJordyHurtadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaJordyHurtadoApplication.class, args);
	}

}
