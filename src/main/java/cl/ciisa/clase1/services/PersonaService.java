package cl.ciisa.clase1.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.ciisa.clase1.entitys.Persona;
import cl.ciisa.clase1.repository.IPersonaRepository;

@Service
public class PersonaService {

	@Autowired
	IPersonaRepository personaRepository;

	@Transactional
	public Persona nuevaPersona(Persona registrarPersona) {
		return personaRepository.save(registrarPersona);
	}

	public Persona modificarPersona(Persona modificarPersona) {
		return personaRepository.save(modificarPersona);
	}

	public Persona buscarPersona(String rut, String primerNombre, String segundoNombre, String tipoUsuario) {
		Boolean consultaPorRut = !Objects.isNull(rut) && !rut.isEmpty() ;
		Boolean consultaPorPrimerNombre = !Objects.isNull(primerNombre) && !primerNombre.isEmpty();
		Boolean consultaPorSegundoNombre = !Objects.isNull(segundoNombre) && !segundoNombre.isEmpty();
		Boolean consultaPorTipoUsuario = !Objects.isNull(tipoUsuario) && !tipoUsuario.isEmpty();
		return personaRepository.buscarPersona(consultaPorRut, consultaPorPrimerNombre, consultaPorSegundoNombre, consultaPorTipoUsuario,  rut, null, null, tipoUsuario);
	}

}
