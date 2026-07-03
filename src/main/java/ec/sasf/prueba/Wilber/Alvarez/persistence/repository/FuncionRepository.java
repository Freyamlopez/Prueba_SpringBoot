package ec.sasf.prueba.Wilber.Alvarez.persistence.repository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Funcion;
import jakarta.persistence.LockModeType;

public interface FuncionRepository extends JpaRepository<Funcion, Long> {
    
    /**
     * obtener una función del cine y bloquearla temporalmente mientras se realiza una reserva, 
     * evitando que dos personas compren el mismo asiento o excedan la capacidad al mismo tiempo.
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT f FROM Funcion f WHERE f.id = :id")
    Optional<Funcion> findByIdForUpdate(@Param("id") Long id);
 
    /**
     * Listar todas las funciones activas en los próximos días (ordenadas por fecha)
     */
    @Query("SELECT f FROM Funcion f " +
           "WHERE f.pelicula.estado = ec.sasf.prueba.Wilber.Alvarez.persistence.entity.EstadoPelicula.ACTIVA " +
           "AND f.fechaHora BETWEEN :desde AND :hasta " +
           "ORDER BY f.fechaHora ASC")
    List<Funcion> findCartelera(@Param("desde") LocalDateTime desde,
                                 @Param("hasta") LocalDateTime hasta);
}
