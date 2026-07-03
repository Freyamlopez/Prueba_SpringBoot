package ec.sasf.rania_ostaiza.Entity;

import jakarta.persistence.*;
import lombok.*;



@Entity
@Table(name = "Sala")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    private String capacidad;

}
