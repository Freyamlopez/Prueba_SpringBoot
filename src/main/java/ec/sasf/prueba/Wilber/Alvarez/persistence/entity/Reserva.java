package ec.sasf.prueba.Wilber.Alvarez.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nombreCliente;

    @Column(nullable = false, length = 150)
    private String emailCliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "funcion_id", nullable = false)
    private Funcion funcion;

    @Column(nullable = false)
    private Integer cantidadEntradas;

    @Column(nullable = false)
    private Double total;

    @Column(nullable = false)
    private LocalDateTime fechaReserva;
}
