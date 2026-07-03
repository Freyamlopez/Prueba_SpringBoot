package ec.sasf.prueba.Wilber.Alvarez.service.dto.request;


import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
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
@Schema(description = "Datos requeridos para programar una nueva funcion")
public class FuncionRequestDTO {
 
    @NotNull(message = "El id de la pelicula es obligatorio")
    @Schema(example = "1")
    private Long peliculaId;
 
    @NotNull(message = "El id de la sala es obligatorio")
    @Schema(example = "1")
    private Long salaId;
 
    @NotNull(message = "La fecha y hora de la funcion es obligatoria")
    @Future(message = "La fecha y hora de la funcion debe ser futura")
    @Schema(example = "2026-07-10T19:30:00")
    private LocalDateTime fechaHora;
 
    @NotNull(message = "El precio de la entrada es obligatorio")
    @Positive(message = "El precio de la entrada debe ser positivo")
    @Schema(example = "5.50")
    private Double precioEntrada;
}