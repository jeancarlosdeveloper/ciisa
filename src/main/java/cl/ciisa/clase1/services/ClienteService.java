package cl.ciisa.clase1.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.GsonBuilder;

import cl.ciisa.clase1.DTO.ClienteDTO;
import cl.ciisa.clase1.entitys.Persona;
import cl.ciisa.clase1.entitys.Usuario;
import cl.ciisa.clase1.mappers.ISolicitudClienteMapper;

@Service
public class ClienteService {

	@Autowired
	PersonaService personaService;

	@Autowired
	UsuarioService usuarioService;

	public String nuevoCliente(ClienteDTO solicitudRegistro) {

		//Registro de persona
		Persona personaARegistrar = ISolicitudClienteMapper.INSTANCE.registroClienteToPersona(solicitudRegistro);
		Persona personaRegistrada = personaService.nuevaPersona(personaARegistrar);
		solicitudRegistro.setId(personaRegistrada.getId());
		
		//Registro de usuario automatico
		Usuario usuarioARegistrar = ISolicitudClienteMapper.INSTANCE.registroClienteToUsuario(solicitudRegistro);
		Usuario usuarioRegistrado = usuarioService.nuevoUsuario(usuarioARegistrar);
		
		//Construyendo respuesta json para el cliente
		return this.responderACliente(personaRegistrada, usuarioRegistrado, "registrado");
	}

	public String modificarCliente(ClienteDTO solicitudModificar) {

		//Modificacion de persona
		Persona personaAModificar = ISolicitudClienteMapper.INSTANCE.registroClienteToPersona(solicitudModificar);
		Persona personaModificada=  personaService.modificarPersona(personaAModificar);
		
		//Modificacion de usuario
		Usuario usuarioAModificar = ISolicitudClienteMapper.INSTANCE.registroClienteToUsuario(solicitudModificar);
		Usuario usuarioModificado = usuarioService.modificarUsuario(usuarioAModificar);
		
		//Construyendo respuesta json para el cliente
		return this.responderACliente(personaModificada, usuarioModificado, "modificado");
	}
	
	

	public String buscarCliente(String rut, String primerNombre, String segundoNombre, String tipoUsuario) {
				
			Persona personaEncontrada=personaService.buscarPersona(rut, primerNombre, segundoNombre, tipoUsuario);
		
			Map<String, Object>respuesta= new HashMap<>();
			respuesta.put("Cliente encontrado",personaEncontrada);
	
			return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
	}
	
	private String responderACliente(Persona persona, Usuario usuario, String operacion) {
		Map<String, Object>respuesta= new HashMap<>();
		respuesta.put("Datos de cliente "+operacion, persona);
		respuesta.put("Datos de usuario", usuario);
		//Construyendo respuesta json para el cliente
		return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
	}

}
