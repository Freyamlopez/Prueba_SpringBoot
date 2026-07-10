package com.example.pruebaJordyHurtado.service;

import com.example.pruebaJordyHurtado.persistence.entity.ClientEntity;
import com.example.pruebaJordyHurtado.persistence.repository.ClientCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientCrudRepository clientCrudRepository;

    @Autowired
    public ClientService(ClientCrudRepository clientCrudRepository) {
        this.clientCrudRepository = clientCrudRepository;
    }


    public List<ClientEntity> getAll (){
        return this.clientCrudRepository.findAll();
    }

    public ClientEntity save(ClientEntity client){
        return this.clientCrudRepository.save(client);
    }

    public ClientEntity getClientById (long id){
        return this.clientCrudRepository.findById(id).orElse(null);
    }


}
