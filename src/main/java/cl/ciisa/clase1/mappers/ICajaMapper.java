package cl.ciisa.clase1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cl.ciisa.clase1.DTO.CajaRegistroPagoDTO;
import cl.ciisa.clase1.entitys.Caja;

@Mapper
public interface ICajaMapper {

	ICajaMapper INSTANCE = Mappers.getMapper(ICajaMapper.class);
	
	@Mapping(target="idCajera", source="usuario.id")
	@Mapping(target="idTipoPago", source="tipoPago.id")
	@Mapping(target="idReservaCliente", source="reservaCliente.id")
	CajaRegistroPagoDTO cajaToCajaRegistroPagoDTO(Caja caja);
	
	@Mapping(source="idCajera", target="usuario.id")
	@Mapping(source="idTipoPago", target="tipoPago.id")
	@Mapping(source="idReservaCliente", target="reservaCliente.id")
	Caja cajaRegistroPagoDTOToCaja(CajaRegistroPagoDTO cajaRegistroPagoDTO);
	
}
