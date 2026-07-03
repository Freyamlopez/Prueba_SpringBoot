package ec.sasf.prueba.Wilber.Alvarez.persistence.mapper;



import org.springframework.stereotype.Component;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Sala;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.SalaRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.SalaResponseDTO;
 
@Component
public class SalaMapper {
 
    public Sala toEntity(SalaRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Sala.builder()
                .nombre(dto.getNombre())
                .capacidad(dto.getCapacidad())
                .build();
    }
 
    public SalaResponseDTO toResponse(Sala entity) {
        if (entity == null) {
            return null;
        }
        return SalaResponseDTO.builder()
                .id(entity.getId())
                .nombre(entity.getNombre())
                .capacidad(entity.getCapacidad())
                .build();
    }
}