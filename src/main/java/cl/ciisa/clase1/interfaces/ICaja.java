package cl.ciisa.clase1.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ciisa.clase1.DTO.CajaRegistroPagoDTO;

@RequestMapping("/caja")
public interface ICaja {
	
	@PostMapping("/registro-pago")
	public CajaRegistroPagoDTO registroPago(@RequestBody CajaRegistroPagoDTO solicitudRegistro);
	
}
