package ec.sasf.rania_ostaiza.Entity;


import java.util.Date;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "Reserva")
@Getter
@Setter @AllArgsConstructor @NoArgsConstructor

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombreCliente;

    private String emailCliente;

    @ManyToOne
    private Funcion funcion;

    private int cantidadEntradas;

    private Double total;

    private Date fechaReserva;
}
