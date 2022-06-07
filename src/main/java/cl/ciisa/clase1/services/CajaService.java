package cl.ciisa.clase1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.DTO.CajaRegistroPagoDTO;
import cl.ciisa.clase1.entitys.Caja;
import cl.ciisa.clase1.mappers.ICajaMapper;
import cl.ciisa.clase1.repository.ICajaRepository;

@Service
public class CajaService {

	@Autowired
	ICajaRepository cajaRepository;

	public CajaRegistroPagoDTO registroPago(CajaRegistroPagoDTO solicitudRegistro) {
		Caja converirAEntidad = ICajaMapper.INSTANCE.cajaRegistroPagoDTOToCaja(solicitudRegistro);
		CajaRegistroPagoDTO convertirADTO = ICajaMapper.INSTANCE.cajaToCajaRegistroPagoDTO(cajaRepository.save(converirAEntidad));
		return convertirADTO;
	}
	
	public void obtenerConsumosMesa() {
		
	}

}
