package ec.sasf.prueba.Wilber.Alvarez.persistence.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    
}
