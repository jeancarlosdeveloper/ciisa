package cl.ciisa.clase1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.entitys.Reserva;
import cl.ciisa.clase1.repository.IReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private IReservaRepository reservaRepository;
	
	public List<Reserva> findAll() {
		return reservaRepository.findAll();
	}
	
}
