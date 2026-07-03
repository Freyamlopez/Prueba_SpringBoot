package ec.sasf.prueba.Wilber.Alvarez.persistence.mapper;

import org.springframework.stereotype.Component;

import ec.sasf.prueba.Wilber.Alvarez.persistence.entity.Reserva;
import ec.sasf.prueba.Wilber.Alvarez.service.dto.response.ReservaResponseDTO;
 
@Component
public class ReservaMapper {
 
    private final FuncionMapper funcionMapper;
 
    public ReservaMapper(FuncionMapper funcionMapper) {
        this.funcionMapper = funcionMapper;
    }
 
    public ReservaResponseDTO toResponse(Reserva entity) {
        if (entity == null) {
            return null;
        }
        return ReservaResponseDTO.builder()
                .id(entity.getId())
                .nombreCliente(entity.getNombreCliente())
                .emailCliente(entity.getEmailCliente())
                .funcion(funcionMapper.toResponse(entity.getFuncion()))
                .cantidadEntradas(entity.getCantidadEntradas())
                .total(entity.getTotal())
                .fechaReserva(entity.getFechaReserva())
                .build();
    }
}