package ec.sasf.prueba.Wilber.Alvarez.service.dto.request;


import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.EstadoPelicula;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
@Schema(description = "Datos requeridos para registrar una nueva pelicula")
public class PeliculaRequestDTO {
 
    @NotBlank(message = "El titulo es obligatorio")
    @Schema(example = "Interstellar")
    private String titulo;
 
    @Schema(example = "Un grupo de astronautas viaja a traves de un agujero de gusano en busca de un nuevo hogar para la humanidad.")
    private String descripcion;
 
    @NotNull(message = "La duracion es obligatoria")
    @Schema(example = "169")
    private Integer duracion;
 
    @Schema(example = "Ciencia ficcion")
    private String genero;
 
    @Schema(example = "PG-13")
    private String clasificacion;

    
    @Schema(example = "ACTIVA", description = "ACTIVA o INACTIVA. Si se omite, por defecto es ACTIVA")
    private EstadoPelicula estado; 

  
}
