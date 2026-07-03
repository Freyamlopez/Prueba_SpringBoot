package ec.sasf.prueba.Wilber.Alvarez.persistence.mapper;


import org.springframework.stereotype.Component;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Funcion;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.FuncionResponseDTO;
 
@Component
public class FuncionMapper {
 
    private final PeliculaMapper peliculaMapper;
    private final SalaMapper salaMapper;
 
    public FuncionMapper(PeliculaMapper peliculaMapper, SalaMapper salaMapper) {
        this.peliculaMapper = peliculaMapper;
        this.salaMapper = salaMapper;
    }
 
    public FuncionResponseDTO toResponse(Funcion entity) {
        if (entity == null) {
            return null;
        }
        return FuncionResponseDTO.builder()
                .id(entity.getId())
                .pelicula(peliculaMapper.toResponse(entity.getPelicula()))
                .sala(salaMapper.toResponse(entity.getSala()))
                .fechaHora(entity.getFechaHora())
                .precioEntrada(entity.getPrecioEntrada())
                .capacidadDisponible(entity.getCapacidadDisponible())
                .build();
    }
}