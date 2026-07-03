package ec.sasf.prueba.Wilber.Alvarez.service.exception;

 
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
 
import java.time.LocalDateTime;
import java.util.List;
 
/**
 * Estructura uniforme de error devuelta por el GlobalExceptionHandler para todos los endpoints de la API.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {
 
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private List<String> detalles;
}
