
package com.example.pruebaJordyHurtado.service;


import com.example.pruebaJordyHurtado.persistence.entity.ClientEntity;
import com.example.pruebaJordyHurtado.persistence.entity.OrderEntity;
import com.example.pruebaJordyHurtado.persistence.entity.ProductEntity;
import com.example.pruebaJordyHurtado.persistence.repository.ClientCrudRepository;
import com.example.pruebaJordyHurtado.persistence.repository.OrderCrudRepository;
import com.example.pruebaJordyHurtado.persistence.repository.ProductCrudRepository;
import com.example.pruebaJordyHurtado.web.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderCrudRepository orderCrudRepository;
    private final ClientCrudRepository clientCrudRepository;
    private final ProductCrudRepository productCrudRepository;


    @Autowired
    public OrderService(OrderCrudRepository orderCrudRepository, ClientCrudRepository clientCrudRepository, ProductCrudRepository productCrudRepository) {
        this.orderCrudRepository = orderCrudRepository;
        this.clientCrudRepository = clientCrudRepository;
        this.productCrudRepository = productCrudRepository;
    }




    public OrderEntity save(OrderDto orderDto) {
        ClientEntity client = clientCrudRepository.findById(orderDto.getIdClient()).orElse(null);

        if(client == null){
            return null;
        }

        List<ProductEntity> productos = productCrudRepository.findAllById(orderDto.getIdsProducts());;

        double total = 0;

        for(ProductEntity producto : productos){
            if(Boolean.TRUE.equals(producto.getDisponible())){
                total += producto.getPrecio();
            }
        }

        OrderEntity orden = new OrderEntity();

        orden.setClient(client);
        orden.setProducts(productos);
        orden.setFecha(LocalDateTime.now());
        orden.setTotal(total);

        return orderCrudRepository.save(orden);

    }



    public List<OrderEntity> getByClient(Long idCliente){
        return this.orderCrudRepository.findByClientId(idCliente);
    }



     public List<OrderEntity> getALL (){
        return this.orderCrudRepository.findAll();
    }
}
