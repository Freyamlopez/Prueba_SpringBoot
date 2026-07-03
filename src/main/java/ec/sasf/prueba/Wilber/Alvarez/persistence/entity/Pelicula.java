package ec.sasf.prueba.Wilber.Alvarez.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "peliculas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pelicula extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(length = 2000)
    private String descripcion;

    @Column(nullable = false)
    private Integer duracion; // minutos

    @Column(length = 100)
    private String genero;

    @Column(length = 20)
    private String clasificacion; // Ej: PG-13, R

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @Builder.Default
    private EstadoPelicula estado = EstadoPelicula.ACTIVA;
}