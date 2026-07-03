package ec.sasf.prueba.Wilber.Alvarez.web.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.prueba.Wilber.Alvarez.service.PeliculaServiceImpl;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.PeliculaRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.PeliculaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/peliculas")
@Tag(
    name = "Películas",
    description = "API para la gestión de películas"
)
public class PeliculaController {

    private final PeliculaServiceImpl peliculaService;

    public PeliculaController(PeliculaServiceImpl peliculaService) {
        this.peliculaService = peliculaService;
    }

    @Operation(
        summary = "Registrar una película",
        description = "Registra una nueva película en el sistema."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Película registrada correctamente",
            content = @Content(schema = @Schema(implementation = PeliculaResponseDTO.class))
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos de entrada inválidos"
        )
    })
    @PostMapping
    public ResponseEntity<PeliculaResponseDTO> registrar(
            @Valid @RequestBody PeliculaRequestDTO dto) {

        PeliculaResponseDTO respuesta = peliculaService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(respuesta);
    }

    @Operation(
        summary = "Listar películas",
        description = "Obtiene el listado de todas las películas registradas."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Listado obtenido correctamente"
        )
    })
    @GetMapping
    public ResponseEntity<List<PeliculaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(peliculaService.listarTodas());
    }

    @Operation(
        summary = "Buscar película por ID",
        description = "Obtiene la información de una película a partir de su identificador."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Película encontrada",
            content = @Content(schema = @Schema(implementation = PeliculaResponseDTO.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Película no encontrada"
        )
    })
    @GetMapping("/{id}")
    public ResponseEntity<PeliculaResponseDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(peliculaService.obtenerPorId(id));
    }

}
