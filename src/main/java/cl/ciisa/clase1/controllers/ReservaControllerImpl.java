package cl.ciisa.clase1.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;

import cl.ciisa.clase1.DTO.ClienteDTO;
import cl.ciisa.clase1.DTO.ReservacionDTO;
import cl.ciisa.clase1.entitys.ReservaCliente;
import cl.ciisa.clase1.interfaces.IReserva;
import cl.ciisa.clase1.mappers.IReservacionMapper;
import cl.ciisa.clase1.services.ClienteService;
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
	
	@Autowired
	ClienteService clienteService;
	
	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public String nuevaReserva(ReservacionDTO solicitudRegistroReservacion) {
		
		//Guardando cliente automaticamente con sus datos personales y generando un usuario.
		ClienteDTO registrarCliente=IReservacionMapper.INSTANCE.reservacionDTOToClienteDTO(solicitudRegistroReservacion);
		Map<String, Object> clienteRegistrado= clienteService.nuevoCliente(registrarCliente);
		
		//Guardar la reserva.
		ReservaCliente reservaARegistrar = IReservacionMapper.INSTANCE.reservacionDTOToReservaCliente(solicitudRegistroReservacion);
		reservaService.nuevaReserva(reservaARegistrar);
		
		Map<String, Object>respuesta= new HashMap<>();
		respuesta.put("ReservaRegistrada", reservaARegistrar);
		respuesta.putAll(clienteRegistrado);
		
		return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
		
	}

	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public String modificarReserva(ReservacionDTO solicitudModificarReservacion) {
		
		//Modificando reserva
		ReservaCliente reservaAModificar = IReservacionMapper.INSTANCE.reservacionDTOToReservaCliente(solicitudModificarReservacion);
		ReservaCliente reservaModificada= reservaService.modificarReserva(reservaAModificar);

		Map<String, Object>respuesta= new HashMap<>();
		respuesta.put("ReservaModificada", reservaModificada);
		
		return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
	}

	@Override
	public String buscarReserva(String rut, String fechaHoraReserva, String idMesa) {
		Map<String, Object>respuesta= new HashMap<>();
		respuesta.put("Reserva", reservaService.buscarReserva(rut, fechaHoraReserva, idMesa));
		return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
	}

}
