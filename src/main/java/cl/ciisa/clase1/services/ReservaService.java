package cl.ciisa.clase1.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.entitys.ReservaCliente;
import cl.ciisa.clase1.repository.IReservaClienteRepository;

@Service
public class ReservaService {

	@Autowired
	IReservaClienteRepository reservaClienteRepository;

	@Transactional
	public ReservaCliente nuevaReserva(ReservaCliente registrarReservacionCliente) {
		return reservaClienteRepository.save(registrarReservacionCliente);
	}

	public ReservaCliente modificarReserva(ReservaCliente modificarReservacionCliente) {
		return reservaClienteRepository.save(modificarReservacionCliente);
	}

	public ReservaCliente buscarReserva(String rut, String fechaHoraReserva, String idMesa) {

		Boolean consultaPorRut = rut != null && !rut.isEmpty() ? true : false;
		Boolean consultaPorFechaHoraReserva = fechaHoraReserva != null && !fechaHoraReserva.isEmpty() ? true : false;
		Boolean consultaPorIdMesa = idMesa != null && !idMesa.isEmpty() ? true : false;
		
		System.out.println(fechaHoraReserva);

		return reservaClienteRepository.buscarReserva(consultaPorRut, consultaPorFechaHoraReserva,consultaPorIdMesa, rut, null, null);
	}

}
