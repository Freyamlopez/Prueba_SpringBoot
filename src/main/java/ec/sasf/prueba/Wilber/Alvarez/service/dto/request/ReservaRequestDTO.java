package ec.sasf.prueba.Wilber.Alvarez.service.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
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
@Schema(description = "Datos requeridos para crear una reserva de entradas")
public class ReservaRequestDTO {
 
    @NotBlank(message = "El nombre del cliente es obligatorio")
    @Schema(example = "Juan Perez")
    private String nombreCliente;
 
    @NotBlank(message = "El email del cliente es obligatorio")
    @Email(message = "El email del cliente debe tener un formato valido")
    @Schema(example = "juan.perez@example.com")
    private String emailCliente;
 
    @NotNull(message = "El id de la funcion es obligatorio")
    @Schema(example = "1")
    private Long funcionId;
 
    @NotNull(message = "La cantidad de entradas es obligatoria")
    @Positive(message = "La cantidad de entradas debe ser mayor a cero")
    @Schema(example = "3")
    private Integer cantidadEntradas;
}
