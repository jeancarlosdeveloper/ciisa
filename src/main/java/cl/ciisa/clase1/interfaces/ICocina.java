package cl.ciisa.clase1.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cocina")
public interface ICocina {

	@GetMapping("/ingredientes-disponibles")
	public List<String> obtenerIngredientesDisponibles();
	
	@GetMapping("/pedidos-realizados")
	public List<String> obtenerPedidosRealizados();
	
}
