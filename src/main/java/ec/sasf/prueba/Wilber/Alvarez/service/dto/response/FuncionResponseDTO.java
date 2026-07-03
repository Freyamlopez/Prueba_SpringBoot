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
public class FuncionResponseDTO {
    private Long id;
    private PeliculaResponseDTO pelicula;
    private SalaResponseDTO sala;
    private LocalDateTime fechaHora;
    private Double precioEntrada;
    private Integer capacidadDisponible;
}
 
