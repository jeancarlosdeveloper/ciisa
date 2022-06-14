package cl.ciisa.clase1.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reserva")
public interface IReserva {
	
	@PostMapping("/nueva")
	public void registrarNuevaReserva();
	


}
