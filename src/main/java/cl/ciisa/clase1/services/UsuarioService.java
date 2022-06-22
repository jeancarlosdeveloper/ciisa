package cl.ciisa.clase1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.entitys.Usuario;
import cl.ciisa.clase1.repository.IUsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	IUsuarioRepository usuarioRepository;
	
	public Usuario nuevoUsuario(Usuario solicitudRegistroUsuario) {
		return usuarioRepository.save(solicitudRegistroUsuario);
	}
	
	public Usuario modificarUsuario(Usuario solicitudModificarUsuario) {
		return usuarioRepository.save(solicitudModificarUsuario);
	}
}
