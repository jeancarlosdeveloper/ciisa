package cl.ciisa.clase1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

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

	@Override
	public List<String> registrarNuevoCliente() {
		// TODO Auto-generated method stub
		return null;
	}

}
