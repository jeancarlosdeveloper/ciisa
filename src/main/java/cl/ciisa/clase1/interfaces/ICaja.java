package cl.ciisa.clase1.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ciisa.clase1.DTO.CajaRegistroPagoDTO;

@RequestMapping("/caja")
public interface ICaja {
	
	@PostMapping("/pago")
	public CajaRegistroPagoDTO registroPago(@RequestBody CajaRegistroPagoDTO solicitudRegistro);
	
	@GetMapping("/obtener-consumos/{idmesa}")
	public void obtenerConsumosMesa(@PathVariable("idmesa") Integer idMesa);
}
