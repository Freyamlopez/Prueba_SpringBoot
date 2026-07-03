package ec.sasf.prueba.Wilber.Alvarez.persistence.mapper;

import org.springframework.stereotype.Component;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.EstadoPelicula;
import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Pelicula;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.request.PeliculaRequestDTO;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.PeliculaResponseDTO;


@Component
public class PeliculaMapper {
 
    public Pelicula toEntity(PeliculaRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return Pelicula.builder()
                .titulo(dto.getTitulo())
                .descripcion(dto.getDescripcion())
                .duracion(dto.getDuracion())
                .genero(dto.getGenero())
                .clasificacion(dto.getClasificacion())
                .estado(dto.getEstado() != null ? dto.getEstado() : EstadoPelicula.ACTIVA)
                .build();
    }
 
    public PeliculaResponseDTO toResponse(Pelicula entity) {
        if (entity == null) {
            return null;
        }
        return PeliculaResponseDTO.builder()
                .id(entity.getId())
                .titulo(entity.getTitulo())
                .descripcion(entity.getDescripcion())
                .duracion(entity.getDuracion())
                .genero(entity.getGenero())
                .clasificacion(entity.getClasificacion())
                .estado(entity.getEstado())
                .build();
    }
}
 