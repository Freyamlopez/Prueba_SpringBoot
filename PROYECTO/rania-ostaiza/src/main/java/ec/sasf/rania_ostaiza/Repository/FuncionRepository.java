package ec.sasf.rania_ostaiza.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.sasf.rania_ostaiza.Entity.Funcion;

public interface FuncionRepository extends JpaRepository<Funcion, Long>{

    List<Funcion>findByFecha
}
