package cl.ciisa.clase1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.entitys.ReservaCliente;
import cl.ciisa.clase1.repository.IReservaClienteRepository;

@Service
public class ReservaService {
	
	@Autowired
	IReservaClienteRepository reservaClienteRepository;
	
	public ReservaCliente nuevaReserva(ReservaCliente registrarReservacionCliente) {
		return reservaClienteRepository.save(registrarReservacionCliente);
	}
	
	public ReservaCliente modificarReserva(ReservaCliente modificarReservacionCliente) {
		return reservaClienteRepository.save(modificarReservacionCliente);
	}
	
	public void buscarReserva() {
			
	}
	
	
	
}
