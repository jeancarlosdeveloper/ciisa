package cl.ciisa.clase1.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bodega")
public interface IBodega {

	@GetMapping("/ingredientes-disponibles")
	public List<String> obtenerIngredientesDisponibles();
	
}
