package cl.ciisa.clase1.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_usuario")
	Long id;
	
	Boolean activo = true;
	
	Boolean deleted = false;
	
	@OneToOne
	@JoinColumn(name="id_persona")
	Persona persona;
	
	@OneToOne
	@JoinColumn(name="id_tipo_usuario")
	TipoUsuario tipoUsuario;
	
	
		
}
