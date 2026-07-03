package ec.sasf.rania_ostaiza.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Pelicula")
@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;

    private String duracion;

    private String genero;

    private String clasificacion;

    private String estado;
}
