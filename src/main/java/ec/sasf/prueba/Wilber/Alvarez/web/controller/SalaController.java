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
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@RestController
@RequestMapping("/salas")
@Tag(name = "Salas", description = "Gestion de salas del cine")
public class SalaController {
 
    private final SalaServiceImpl salaService;
 
    public SalaController(SalaServiceImpl salaService) {
        this.salaService = salaService;
    }
 
    @PostMapping
    @Operation(summary = "Registrar una nueva sala")
    public ResponseEntity<SalaResponseDTO> registrar(@Valid @RequestBody SalaRequestDTO dto) {
        log.info("POST /salas - registrando sala '{}'", dto.getNombre());
        SalaResponseDTO response = salaService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
 
    @GetMapping
    @Operation(summary = "Listar todas las salas registradas")
    public ResponseEntity<List<SalaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(salaService.listarTodas());
    }
 
    @GetMapping("/{id}")
    @Operation(summary = "Obtener una sala por id")
    public ResponseEntity<SalaResponseDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(salaService.obtenerPorId(id));
    }
}