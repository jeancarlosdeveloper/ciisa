package cl.ciisa.clase1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import cl.ciisa.clase1.entitys.Reserva;
import cl.ciisa.clase1.interfaces.IReserva;
import cl.ciisa.clase1.services.ReservaService;

@RestController
public class ReservaControllerImpl implements IReserva {

	@Autowired
	private ReservaService reservaService;
	
	@Override
	public ResponseEntity<List<Reserva>> findAll() {
		return ResponseEntity.ok(reservaService.findAll());
	}

}
