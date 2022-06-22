package cl.ciisa.clase1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.repository.IBodegaRepository;

@Service
public class BodegaService {
	
	@Autowired
	IBodegaRepository bodegaRepository;
	
	public void obtenerIngredientesDisponibles() {
		
	}
	
	
}
