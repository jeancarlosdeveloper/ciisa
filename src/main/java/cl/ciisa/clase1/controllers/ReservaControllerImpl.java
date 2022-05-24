package cl.ciisa.clase1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import cl.ciisa.clase1.DTO.ReservaDTO;
import cl.ciisa.clase1.interfaces.IReserva;
import cl.ciisa.clase1.services.ReservaService;

@RestController
public class ReservaControllerImpl implements IReserva {

	@Autowired
	private ReservaService reservaService;
	
	@Override
	public List<ReservaDTO> findAll() {
		return reservaService.findAll();
	}

}
