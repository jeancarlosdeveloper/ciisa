package cl.ciisa.clase1.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cl.ciisa.clase1.DTO.ReservaDTO;
import cl.ciisa.clase1.entitys.Reserva;

@Mapper
public interface IReservaMapper {
	
	IReservaMapper INSTANCE = Mappers.getMapper(IReservaMapper.class);
	
	List<ReservaDTO> listReservaToListReservaDTO(List<Reserva>reservas);
	

}
