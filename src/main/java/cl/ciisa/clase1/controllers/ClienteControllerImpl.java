package cl.ciisa.clase1.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;

import cl.ciisa.clase1.DTO.ClienteDTO;
import cl.ciisa.clase1.interfaces.ICliente;
import cl.ciisa.clase1.services.ClienteService;

/**
 * @author Jean Carlos
 * @since 07-06-2022
 */

@RestController
@CrossOrigin(origins = "*")
public class ClienteControllerImpl implements ICliente {

	@Autowired
	ClienteService clienteService;

	@ResponseStatus(HttpStatus.CREATED)
	@Override
	public String nuevoCliente(ClienteDTO solicitudRegistroCliente) {
		Map<String, Object> respuesta = new ResponseEntity<Map<String, Object>>(
				clienteService.nuevoCliente(solicitudRegistroCliente), HttpStatus.CREATED).getBody();
		return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
	}

	@Override
	@ResponseStatus(HttpStatus.CREATED)
	public String modificarCliente(ClienteDTO solicitudModificarCliente) {
		Map<String, Object> respuesta = new ResponseEntity<Map<String, Object>>(
				clienteService.modificarCliente(solicitudModificarCliente), HttpStatus.CREATED).getBody();
		return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	public String buscarCliente(String rut, String primerNombre, String segundoNombre, String tipoUsuario) {
		return new ResponseEntity<String>(clienteService.buscarCliente(rut, primerNombre, segundoNombre, tipoUsuario),
				HttpStatus.OK).getBody();
	}

}
