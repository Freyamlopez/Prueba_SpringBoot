package ec.sasf.prueba.Wilber.Alvarez.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    
}
