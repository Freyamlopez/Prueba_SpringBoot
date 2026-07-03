package ec.sasf.prueba.Wilber.Alvarez.service.dto.response;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
 
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaResponseDTO {
    private Long id;
    private String nombreCliente;
    private String emailCliente;
    private FuncionResponseDTO funcion;
    private Integer cantidadEntradas;
    private Double total;
    private LocalDateTime fechaReserva;
}
