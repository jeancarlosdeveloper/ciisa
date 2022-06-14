package cl.ciisa.clase1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import cl.ciisa.clase1.DTO.FrontCajaRegistroPagoDTO;
import cl.ciisa.clase1.interfaces.ICaja;
import cl.ciisa.clase1.services.CajaService;

/**
 * @author Jean Carlos
 * @since 07-06-2022
 */

@RestController
@CrossOrigin(origins = "*")
public class CajaControllerImpl implements ICaja {

	@Autowired
	CajaService cajaService;

	/**
	 * Feat: Metodo: registroPago(), realiza registro de pago en caja para los clientes.
	 * 
	 * @param FrontCajaRegistroPagoDTO
	 * @return CajaRegistroPagoDTO
	 * 
	 **/

	@Override
	public FrontCajaRegistroPagoDTO registroPago(FrontCajaRegistroPagoDTO solicitudRegistro) {
		return cajaService.registrarPago(solicitudRegistro);
	}

	
	/**
	 * Feat: Metodo obtenerConsumosMesa(), obtiene todos los consumos de una mesa en particular.
	 * 
	 * @param FrontCajaRegistroPagoDTO
	 * @return CajaRegistroPagoDTO
	 * 
	 **/
	
	@Override
	public void obtenerConsumosMesa(Integer idMesa) {
		cajaService.obtenerConsumosMesa();
	}

}
