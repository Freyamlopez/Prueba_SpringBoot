package ec.sasf.rania_ostaiza.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Funcion")
@Getter
@Setter @AllArgsConstructor @NoArgsConstructor
public class Funcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Pelicula pelicula;

    @ManyToOne
    private Sala sala;

    private LocalDateTime fechaHora;

    private Double precioEntrada;
}
