package cl.ciisa.clase1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import cl.ciisa.clase1.DTO.CajaRegistroPagoDTO;
import cl.ciisa.clase1.interfaces.ICaja;
import cl.ciisa.clase1.services.CajaService;

@RestController
@CrossOrigin(origins = "*")
public class CajaControllerImpl implements ICaja {

	@Autowired
	CajaService cajaService;
	
	@Override
	public CajaRegistroPagoDTO registroPago(CajaRegistroPagoDTO solicitudRegistro) {
		return cajaService.registroPago(solicitudRegistro);
	}

	

}
