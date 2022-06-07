package cl.ciisa.clase1.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cliente")
public interface ICliente {

	@PostMapping("/nuevo")
	public List<String> registrarNuevoCliente();
	
}
