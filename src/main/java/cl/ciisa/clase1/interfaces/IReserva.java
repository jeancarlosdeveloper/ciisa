package cl.ciisa.clase1.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ciisa.clase1.DTO.ReservacionDTO;

@RequestMapping("/reserva")
public interface IReserva {
	
	@PostMapping("/nueva")
	public String nuevaReserva(@RequestBody ReservacionDTO solicitudRegistroReservacion);
	
	@PutMapping("/modificar")
	public String modificarReserva(@RequestBody ReservacionDTO solicitudModificarReservacion);
	
	@GetMapping("/busqueda/avanzada")
	public String buscarReserva(
			@RequestHeader(value="rut",required=false) String rut,
			@RequestHeader(value="fechaHoraReserva", required=false) String fechaHoraReserva,
			@RequestHeader(value="idMesa",required=false) String idMesa);
	
}
