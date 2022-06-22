package cl.ciisa.clase1.interfaces;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.ciisa.clase1.DTO.ClienteDTO;

@RequestMapping("/cliente")
public interface ICliente {

	@PostMapping("/nuevo")
	public String nuevoCliente(@RequestBody ClienteDTO solicitudRegistroCliente);
	
	@PutMapping("/modificar")
	public String modificarCliente(@RequestBody ClienteDTO solicitudModificarCliente);
	
	@GetMapping("/busqueda/avanzada")
	public String buscarCliente(
			@RequestParam("rut") String rut,
			@RequestParam("primerNombre") String primerNombre,
			@RequestParam("segundoNombre") String segundoNombre,
			@RequestParam("tipoUsuario") String tipoUsuario);
}
