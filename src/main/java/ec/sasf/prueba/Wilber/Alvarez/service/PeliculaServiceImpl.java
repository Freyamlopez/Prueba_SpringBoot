package ec.sasf.prueba.Wilber.Alvarez.service;


import java.util.List;

import org.springframework.stereotype.Service;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Pelicula;
import ec.sasf.prueba.Wilber.Alvarez.persistence.mapper.PeliculaMapper;
import ec.sasf.prueba.Wilber.Alvarez.persistence.repository.PeliculaRepository;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.PeliculaRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.PeliculaResponseDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
@Transactional
public class PeliculaServiceImpl  {
 
    private final PeliculaRepository peliculaRepository;
    private final PeliculaMapper peliculaMapper;
 
    public PeliculaServiceImpl(PeliculaRepository peliculaRepository, PeliculaMapper peliculaMapper) {
        this.peliculaRepository = peliculaRepository;
        this.peliculaMapper = peliculaMapper;
    }
 
    public PeliculaResponseDTO registrar(PeliculaRequestDTO dto) {
        Pelicula pelicula = peliculaMapper.toEntity(dto);
        Pelicula guardada = peliculaRepository.save(pelicula);
        log.info("Pelicula registrada: id={}, titulo='{}', estado={}",
                guardada.getId(), guardada.getTitulo(), guardada.getEstado());
        return peliculaMapper.toResponse(guardada);
    }
 
   
    @Transactional
    public List<PeliculaResponseDTO> listarTodas() {
        return peliculaRepository.findAll().stream()
                .map(peliculaMapper::toResponse)
                .toList();
    }
 
   
    @Transactional
    public PeliculaResponseDTO obtenerPorId(Long id) {
        return peliculaMapper.toResponse(obtenerEntidadPorId(id));
    }
 
  
    @Transactional
    public Pelicula obtenerEntidadPorId(Long id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.of("Pelicula", id));
    }
}