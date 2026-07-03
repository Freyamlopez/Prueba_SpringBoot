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

import ec.sasf.prueba.Wilber.Alvarez.service.SalaServiceImpl;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.SalaRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.SalaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/salas")
@Tag(
    name = "Salas",
    description = "API para la gestión de salas de cine"
)
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaServiceImpl salaService) {
        this.salaServicei = salaService;
    }

    @Operation(
        summary = "Registrar una sala",
        description = "Registra una nueva sala de cine."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "201",
            description = "Sala registrada correctamente",
            content = @Content(schema = @Schema(implementation = SalaResponseDTO.class))
        ),
        @ApiResponse(
            responseCode = "400",
            description = "Datos de entrada inválidos"
        )
    })
    @PostMapping
    public ResponseEntity<SalaResponseDTO> registrar(
            @Valid @RequestBody SalaRequestDTO dto) {

        SalaResponseDTO response = SalaServiceImpl.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Operation(
        summary = "Listar todas las salas",
        description = "Obtiene el listado de todas las salas registradas."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Listado obtenido correctamente"
        )
    })
    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(salaService.listarTodas());
    }

    @Operation(
        summary = "Buscar sala por ID",
        description = "Obtiene la información de una sala mediante su identificador."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200",
            description = "Sala encontrada",
            content = @Content(schema = @Schema(implementation = SalaResponseDTO.class))
        ),
        @ApiResponse(
            responseCode = "404",
            description = "Sala no encontrada"
        )
    })
    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> obtenerPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(salaService.obtenerPorId(id));
    }
}