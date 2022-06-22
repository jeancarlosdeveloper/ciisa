package cl.ciisa.clase1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import cl.ciisa.clase1.DTO.ClienteDTO;
import cl.ciisa.clase1.DTO.ReservacionDTO;
import cl.ciisa.clase1.entitys.ReservaCliente;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IReservacionMapper {

	IReservacionMapper INSTANCE = Mappers.getMapper(IReservacionMapper.class);
	
	@Mappings({
		@Mapping(source="persona.id",target="id"),
		@Mapping(source="persona.rut",target="rut"),
		@Mapping(source="persona.primerNombre",target="primerNombre"),
		@Mapping(source="persona.segundoNombre",target="segundoNombre"),
		@Mapping(source="persona.apellidoPaterno",target="apellidoPaterno"),
		@Mapping(source="persona.apellidoMaterno",target="apellidoMaterno")
	})
	ClienteDTO reservacionDTOToClienteDTO(ReservacionDTO reservacionDTO);
	
	
	@Mappings({
		@Mapping(source="fechaReserva", target = "fechaReserva", dateFormat = "dd-MM-yyyy hh:mm:ss"),
		@Mapping(source="persona.rut",target="persona.rut"),
		@Mapping(source="idMesa",target="mesa.id")
	})
	ReservaCliente reservacionDTOToReservaCliente(ReservacionDTO reservacionDTO);
	
}
