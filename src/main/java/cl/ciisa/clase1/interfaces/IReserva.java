package cl.ciisa.clase1.interfaces;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reserva")
public interface IReserva {
	
	@PostMapping("/nueva")
	public void nuevaReserva();
	
	@PutMapping("/modificar")
	public void modificarReserva();
	
	@GetMapping("/busqueda/avanzada")
	public void buscarReserva(
			@RequestHeader(value="rut",required=false) String rut,
			@RequestHeader(value="fechaHoraReserva", required=false) Date fechaHoraReserva,
			@RequestHeader(value="idMesa",required=false) String idMesa);
	
}
