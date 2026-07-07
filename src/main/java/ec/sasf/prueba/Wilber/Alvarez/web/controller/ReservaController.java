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

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Reserva;
import ec.sasf.prueba.Wilber.Alvarez.service.ReservaServiceImpl;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.ReservaRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.ReservaResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@RestController
@RequestMapping("/reservas")
@Tag(name = "Reservas", description = "Venta y consulta de reservas de entradas")
public class ReservaController {
 
    private final ReservaServiceImpl reservaService;
 
    public ReservaController(ReservaServiceImpl reservaService) {
        this.reservaService = reservaService;
    }
 
    @PostMapping
    @Operation(summary = "Crear una reserva de entradas para una funcion",
            description = "Valida que la cantidad de entradas no supere la capacidad disponible de la funcion, " +
                    "descuenta la capacidad restante y calcula el total (cantidadEntradas * precioEntrada).")
    public ResponseEntity<ReservaResponseDTO> save (@Valid @RequestBody ReservaRequestDTO dto) {
        log.info("POST /reservas - cliente='{}', funcionId={}, entradas={}",
                dto.getEmailCliente(), dto.getFuncionId(), dto.getCantidadEntradas());
        ReservaResponseDTO response = reservaService.registrar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
 
    @GetMapping("/{emailCliente}")
    @Operation(summary = "Consultar historial de reservas de un cliente por email")
    public ResponseEntity<List<Reserva>> obtenerPorCliente(@PathVariable String emailCliente) {
        log.info("GET /reservas/{}", emailCliente);
        return ResponseEntity.ok(reservaService.obtenerEntidadPorEmailCliente(emailCliente));
    }
}
 