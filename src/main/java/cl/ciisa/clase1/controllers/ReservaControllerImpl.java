package cl.ciisa.clase1.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import cl.ciisa.clase1.interfaces.IReserva;
import cl.ciisa.clase1.services.ReservaService;

/**
 * @author Jean Carlos
 * @since 07-06-2022
 */

@RestController
@CrossOrigin(origins = "*")
public class ReservaControllerImpl implements IReserva{

	@Autowired
	ReservaService reservaService;
	
	@Override
	public void nuevaReserva() {
		/**1 Guardar cliente
		 * 2 Guardar reserva
		 **/
		reservaService.nuevaReserva();
		
	}

	@Override
	public void modificarReserva() {
		reservaService.modificarReserva();
	}

	@Override
	public void buscarReserva(String rut, Date fechaHoraReserva, String idMesa) {
		// TODO Auto-generated method stub
		
	}

}
