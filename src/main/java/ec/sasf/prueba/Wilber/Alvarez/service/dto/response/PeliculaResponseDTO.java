package ec.sasf.prueba.Wilber.Alvarez.service.dto.response;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.EstadoPelicula;
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
public class PeliculaResponseDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Integer duracion;
    private String genero;
    private String clasificacion;
    private EstadoPelicula estado;
}