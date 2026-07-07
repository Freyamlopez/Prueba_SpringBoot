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
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@RestController
@RequestMapping("/peliculas")
@Tag(name = "Peliculas", description = "Gestion del catalogo de peliculas")
public class PeliculaController {
 
    private final PeliculaServiceImpl peliculaService;
 
    public PeliculaController(PeliculaServiceImpl peliculaService) {
        this.peliculaService = peliculaService;
    }
 
    @PostMapping
    @Operation(summary = "Registrar una nueva pelicula",
            description = "Crea una pelicula en el catalogo. Si no se indica el estado, se registra como ACTIVA por defecto.")
    public ResponseEntity<PeliculaResponseDTO> registrar(@Valid @RequestBody PeliculaRequestDTO dto) {
        log.info("POST /peliculas - registrando pelicula '{}'", dto.getTitulo());
        PeliculaResponseDTO response = peliculaService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
 
    @GetMapping
    @Operation(summary = "Listar todas las peliculas registradas")
    public ResponseEntity<List<PeliculaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(peliculaService.listarTodas());
    }
 
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una pelicula por id")
    public ResponseEntity<PeliculaResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(peliculaService.obtenerPorId(id));
    }
}
 