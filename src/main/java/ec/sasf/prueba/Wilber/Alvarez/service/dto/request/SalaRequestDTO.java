package ec.sasf.prueba.Wilber.Alvarez.service.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
@Schema(description = "Datos requeridos para registrar una nueva sala")
public class SalaRequestDTO {
 
    @NotBlank(message = "El nombre de la sala es obligatorio")
    @Schema(example = "Sala 1 - IMAX")
    private String nombre;
 
    @NotNull(message = "La capacidad es obligatoria")
    @Positive(message = "La capacidad debe ser un numero positivo")
    @Schema(example = "120")
    private Integer capacidad;
}