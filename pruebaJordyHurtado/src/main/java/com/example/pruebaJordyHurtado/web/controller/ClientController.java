package com.example.pruebaJordyHurtado.web.controller;


import com.example.pruebaJordyHurtado.persistence.entity.ClientEntity;
import com.example.pruebaJordyHurtado.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/client")
public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<ClientEntity>> getAll (){
        return ResponseEntity.ok(this.clientService.getAll());
    }

    @PostMapping
    public ResponseEntity<ClientEntity> save(@RequestBody ClientEntity client){
        return ResponseEntity.ok(this.clientService.save(client));
    }

    @GetMapping ("/{id}")
    public ResponseEntity<ClientEntity> getClientById (@PathVariable Long id){
        return ResponseEntity.ok(this.clientService.getClientById(id));
    }
}
