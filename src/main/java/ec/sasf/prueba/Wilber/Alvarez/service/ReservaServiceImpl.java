package ec.sasf.prueba.Wilber.Alvarez.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Funcion;
import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Reserva;
import ec.sasf.prueba.Wilber.Alvarez.persistence.mapper.ReservaMapper;
import ec.sasf.prueba.Wilber.Alvarez.persistence.repository.FuncionRepository;
import ec.sasf.prueba.Wilber.Alvarez.persistence.repository.ReservaRepository;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.ReservaRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.ReservaResponseDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ReservaServiceImpl {
    private final ReservaRepository reservaRepository;
    private final ReservaMapper reservaMapper;
    private final FuncionRepository funcionRepository;
 
    public ReservaServiceImpl(ReservaRepository reservaRepository, ReservaMapper reservaMapper, FuncionRepository funcionRepository) {
        this.reservaRepository = reservaRepository;
        this.reservaMapper = reservaMapper;
        this.funcionRepository = funcionRepository; 
    }
 
   
    @Transactional
    public ReservaResponseDTO registrar(ReservaRequestDTO dto) {

        Funcion funcion = funcionRepository.findById(dto.getFuncionId())
            .orElseThrow(() -> new RuntimeException("Función no encontrada"));

        Reserva reserva = Reserva.builder()
            .nombreCliente(dto.getNombreCliente())
            .emailCliente(dto.getEmailCliente())
            .funcion(funcion)
            .cantidadEntradas(dto.getCantidadEntradas())
            .total(funcion.getPrecioEntrada() * dto.getCantidadEntradas())
            .fechaReserva(LocalDateTime.now())
            .build();

        Reserva guardada = reservaRepository.save(reserva);

            log.info("Reserva registrada: id={}, cliente='{}', funcionId={}",
                guardada.getId(),
                guardada.getEmailCliente(),
                guardada.getFuncion().getId());

        return reservaMapper.toResponse(guardada);
    }
 
    
    @Transactional
    public List<ReservaResponseDTO> listarTodas() {
        return reservaRepository.findAll().stream()
                .map(reservaMapper::toResponse)
                .toList();
    }
 
    public List<Reserva> obtenerEntidadPorEmailCliente(String emailCliente) {
    return reservaRepository.findByEmailCliente(emailCliente);
}
  
    @Transactional
    public ReservaResponseDTO obtenerEntidadPorId(Long id) {
        return reservaMapper.toResponse(reservaRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.of("Reserva", id)));
    }
}


    
