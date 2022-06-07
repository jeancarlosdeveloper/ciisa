package cl.ciisa.clase1.mappers;

import org.mapstruct.factory.Mappers;

import cl.ciisa.clase1.DTO.CajaRegistroPagoDTO;
import cl.ciisa.clase1.entitys.Caja;

public interface ICajaMapper {

	ICajaMapper INSTANCE = Mappers.getMapper(ICajaMapper.class);
	
	CajaRegistroPagoDTO cajaToCajaRegistroPagoDTO(Caja caja);
	
	Caja cajaRegistroPagoDTOToCaja(CajaRegistroPagoDTO cajaRegistroPagoDTO);
	
}
