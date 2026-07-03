package ec.sasf.prueba.Wilber.Alvarez.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.EstadoPelicula;
import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Funcion;
import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Pelicula;
import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Sala;
import ec.sasf.prueba.Wilber.Alvarez.persistence.mapper.FuncionMapper;
import ec.sasf.prueba.Wilber.Alvarez.persistence.repository.FuncionRepository;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.FuncionRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.FuncionResponseDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.exception.BusinessRuleException;
import ec.sasf.prueba.Wilber.Alvarez.service.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
@Transactional
public class FuncionServiceImpl {
 
    private final FuncionRepository funcionRepository;
    private final PeliculaServiceImpl peliculaService;
    private final SalaServiceImpl salaService;
    private final FuncionMapper funcionMapper;
 
    public FuncionServiceImpl(FuncionRepository funcionRepository,
                               PeliculaServiceImpl peliculaService,
                               SalaServiceImpl salaService,
                               FuncionMapper funcionMapper) {
        this.funcionRepository = funcionRepository;
        this.peliculaService = peliculaService;
        this.salaService = salaService;
        this.funcionMapper = funcionMapper;
    }
 
   
    public FuncionResponseDTO crear(FuncionRequestDTO dto) {
        Pelicula pelicula = peliculaService.obtenerEntidadPorId(dto.getPeliculaId());
 
        // Regla de negocio: una pelicula INACTIVA no puede programarse en funciones.
        if (pelicula.getEstado() != EstadoPelicula.ACTIVA) {
            throw new BusinessRuleException(
                    "No se puede programar una funcion para la pelicula '" + pelicula.getTitulo() +
                    "' porque su estado es " + pelicula.getEstado() + " (debe estar ACTIVA).");
        }
 
        Sala sala = salaService.obtenerEntidadPorId(dto.getSalaId());
 
        Funcion funcion = Funcion.builder()
                .pelicula(pelicula)
                .sala(sala)
                .fechaHora(dto.getFechaHora())
                .precioEntrada(dto.getPrecioEntrada())
                .capacidadDisponible(sala.getCapacidad())
                .build();
 
        Funcion guardada = funcionRepository.save(funcion);
        log.info("Funcion creada: id={}, pelicula='{}', sala='{}', fechaHora={}, capacidadInicial={}",
                guardada.getId(), pelicula.getTitulo(), sala.getNombre(), guardada.getFechaHora(),
                guardada.getCapacidadDisponible());
 
        return funcionMapper.toResponse(guardada);
    }
 
    @Transactional
    public List<FuncionResponseDTO> obtenerCartelera(int dias) {
        LocalDateTime desde = LocalDateTime.now();
        LocalDateTime hasta = desde.plusDays(dias);
        log.debug("Consultando cartelera entre {} y {}", desde, hasta);
        return funcionRepository.findCartelera(desde, hasta).stream()
                .map(funcionMapper::toResponse)
                .toList();
    }
 
   
    @Transactional
    public Funcion obtenerEntidadPorId(Long id) {
        return funcionRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.of("Funcion", id));
    }
}