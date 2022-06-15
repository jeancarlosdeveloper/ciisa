package cl.ciisa.clase1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<String>(clienteService.nuevoCliente(solicitudRegistroCliente), HttpStatus.CREATED).getBody();
	}

	@Override
	@ResponseStatus(HttpStatus.CREATED)
	public String modificarCliente(ClienteDTO solicitudModificarCliente) {
		return new ResponseEntity<String>(clienteService.modificarCliente(solicitudModificarCliente), HttpStatus.CREATED).getBody();
	}

	@Override
	@ResponseStatus(HttpStatus.OK)
	public String buscarCliente(String rut, String primerNombre, String segundoNombre, String tipoUsuario) {
		return new ResponseEntity<String>(clienteService.buscarCliente(rut, primerNombre, segundoNombre, tipoUsuario), HttpStatus.OK).getBody();
	}

}
