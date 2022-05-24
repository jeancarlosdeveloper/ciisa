package cl.ciisa.clase1.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ciisa.clase1.DTO.ReservaDTO;

@RequestMapping("/reservas")
public interface IReserva {
	
	@GetMapping("/")
	public List<ReservaDTO> findAll();
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<T> findBy(@RequestBody AlertasRqBusAPDTO alertas);
//	
//	@PostMapping("/")
//	public ResponseEntity<T> save(@RequestBody AlertasRqDTO alertas);
//
//	@PutMapping("/")
//	public ResponseEntity<T> update(@RequestBody AlertasRqUDTO alertas);
//
//	@PostMapping("bus/")
//	public ResponseDTO delete(@RequestBody AlertasRqBusASDTO alertas);


}
