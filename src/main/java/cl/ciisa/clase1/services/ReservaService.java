package cl.ciisa.clase1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.repository.IReservaClienteRepository;

@Service
public class ReservaService {
	
	@Autowired
	IReservaClienteRepository reservaClienteRepository;
	
	public void nuevaReserva() {
		reservaClienteRepository.save(null);
	}
	
	public void modificarReserva() {
		reservaClienteRepository.save(null);
	}
	
	public void buscarReserva() {
			
	}
	
	
	
}
