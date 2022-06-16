package cl.ciisa.clase1.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.GsonBuilder;

import cl.ciisa.clase1.DTO.ClienteDTO;
import cl.ciisa.clase1.entitys.Persona;
import cl.ciisa.clase1.entitys.Usuario;
import cl.ciisa.clase1.mappers.ISolicitudClienteMapper;

@Transactional
@Service
public class ClienteService {

	@Autowired
	PersonaService personaService;

	@Autowired
	UsuarioService usuarioService;


	/**
	 * El metodo nuevoCliente, registra un cliente con todos sus datos de persona y
	 * ademas realiza un registro automatico del usuario.
	 * 
	 * @param ClienteDTO es el objeto que se envia desde el frontend
	 * @return Retorna un String en formato json con la respuesta que cliente se
	 *         guardo con los datos de usuario.
	 * 
	 **/
	
	public Map<String, Object> nuevoCliente(ClienteDTO solicitudRegistro) {

		//Registro de persona
		Persona personaARegistrar = ISolicitudClienteMapper.INSTANCE.registroClienteToPersona(solicitudRegistro);
		Persona personaRegistrada = personaService.nuevaPersona(personaARegistrar);
		solicitudRegistro.setId(personaRegistrada.getId());
		
		//Registro de usuario automatico
		Usuario usuarioARegistrar = ISolicitudClienteMapper.INSTANCE.registroClienteToUsuario(solicitudRegistro);
		Usuario usuarioRegistrado = usuarioService.nuevoUsuario(usuarioARegistrar);
		
		Map<String, Object>respuesta= new HashMap<>();
		respuesta.put("ClienteRegistrado",personaRegistrada);
		respuesta.put("UsuarioRegistrado",usuarioRegistrado);
	
		//Construyendo respuesta json para el cliente
		return respuesta;
	}
	

	public Map<String, Object> modificarCliente(ClienteDTO solicitudModificar) {

		//Modificacion de persona
		Persona personaAModificar = ISolicitudClienteMapper.INSTANCE.registroClienteToPersona(solicitudModificar);
		Persona personaModificada=  personaService.modificarPersona(personaAModificar);
		
		//Modificacion de usuario
		Usuario usuarioAModificar = ISolicitudClienteMapper.INSTANCE.registroClienteToUsuario(solicitudModificar);
		Usuario usuarioModificado = usuarioService.modificarUsuario(usuarioAModificar);
		
		Map<String, Object>respuesta= new HashMap<>();
		respuesta.put("ClienteModificado",personaModificada);
		respuesta.put("UsuarioModificado",usuarioModificado);
		
		//Construyendo respuesta json para el cliente
		return respuesta;
	}
	
	

	public String buscarCliente(String rut, String primerNombre, String segundoNombre, String tipoUsuario) {
				
			Persona personaEncontrada=personaService.buscarPersona(rut, primerNombre, segundoNombre, tipoUsuario);
		
			Map<String, Object>respuesta= new HashMap<>();
			respuesta.put("Cliente encontrado",personaEncontrada);
	
			return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
	}
	
	public String responderACliente(Persona persona, Usuario usuario, String operacion) {
		
		Map<String, Object>respuesta= new HashMap<>();
		respuesta.put("Datos de cliente "+operacion, persona);
		respuesta.put("Datos de usuario", usuario);
		//Construyendo respuesta json para el cliente
		return new GsonBuilder().setPrettyPrinting().create().toJson(respuesta);
		
	}

}
