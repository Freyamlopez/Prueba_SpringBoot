package ec.sasf.prueba.Wilber.Alvarez.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Reserva;

public interface ReservaRepository  extends JpaRepository<Reserva, Long> {
    
}
