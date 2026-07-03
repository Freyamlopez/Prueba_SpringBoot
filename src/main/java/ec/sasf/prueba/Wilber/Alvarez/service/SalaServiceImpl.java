

package ec.sasf.prueba.Wilber.Alvarez.service;



import java.util.List;

import org.springframework.stereotype.Service;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Sala;
import ec.sasf.prueba.Wilber.Alvarez.persistence.mapper.SalaMapper;
import ec.sasf.prueba.Wilber.Alvarez.persistence.repository.SalaRepository;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.SalaRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.SalaResponseDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.exception.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@Service
@Transactional
public class SalaServiceImpl {
 
    private final SalaRepository salaRepository;
    private final SalaMapper salaMapper;
 
    public SalaServiceImpl(SalaRepository salaRepository, SalaMapper salaMapper) {
        this.salaRepository = salaRepository;
        this.salaMapper = salaMapper;
    }
 
   
    public SalaResponseDTO registrar(SalaRequestDTO dto) {
        Sala sala = salaMapper.toEntity(dto);
        Sala guardada = salaRepository.save(sala);
        log.info("Sala registrada: id={}, nombre='{}', capacidad={}",
                guardada.getId(), guardada.getNombre(), guardada.getCapacidad());
        return salaMapper.toResponse(guardada);
    }
 
    
    @Transactional
    public List<SalaResponseDTO> listarTodas() {
        return salaRepository.findAll().stream()
                .map(salaMapper::toResponse)
                .toList();
    }
 
   
    @Transactional
    public SalaResponseDTO obtenerPorId(Long id) {
        return salaMapper.toResponse(obtenerEntidadPorId(id));
    }
 
  
    @Transactional
    public Sala obtenerEntidadPorId(Long id) {
        return salaRepository.findById(id)
                .orElseThrow(() -> ResourceNotFoundException.of("Sala", id));
    }
}
