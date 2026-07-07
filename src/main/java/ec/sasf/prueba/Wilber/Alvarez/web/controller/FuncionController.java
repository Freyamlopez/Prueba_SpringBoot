package ec.sasf.prueba.Wilber.Alvarez.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.sasf.prueba.Wilber.Alvarez.service.FuncionServiceImpl;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.FuncionRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.FuncionResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@RestController
@Tag(name = "Funciones", description = "Programacion de funciones y cartelera")
public class FuncionController {
 
    private final FuncionServiceImpl funcionService;
 
    public FuncionController(FuncionServiceImpl funcionService) {
        this.funcionService = funcionService;
    }
 
    @PostMapping("/funciones")
    @Operation(summary = "Crear una funcion programada",
            description = "Requiere que la pelicula exista y este ACTIVA, y que la sala exista. " +
                    "La capacidad disponible de la funcion se inicializa con la capacidad de la sala.")
    public ResponseEntity<FuncionResponseDTO> crear(@Valid @RequestBody FuncionRequestDTO dto) {
        log.info("POST /funciones - peliculaId={}, salaId={}, fechaHora={}",
                dto.getPeliculaId(), dto.getSalaId(), dto.getFechaHora());
        FuncionResponseDTO response = funcionService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
 
    @GetMapping("/cartelera")
    @Operation(summary = "Listar la cartelera de funciones activas",
            description = "Devuelve las funciones cuya pelicula esta ACTIVA, programadas dentro de los " +
                    "proximos N dias (por defecto 7), ordenadas por fecha ascendente.")
    public ResponseEntity<List<FuncionResponseDTO>> obtenerCartelera(
            @Parameter(description = "Cantidad de dias hacia adelante a considerar")
            @RequestParam(name = "dias", defaultValue = "7") int dias) {
        log.info("GET /cartelera - dias={}", dias);
        return ResponseEntity.ok(funcionService.obtenerCartelera(dias));
    }
}