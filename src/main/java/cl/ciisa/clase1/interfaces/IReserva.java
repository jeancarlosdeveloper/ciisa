package cl.ciisa.clase1.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import cl.ciisa.clase1.entitys.Reserva;

public interface IReserva {
	
	@GetMapping("/")
	public ResponseEntity<List<Reserva>> findAll();
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
