package cl.ciisa.clase1.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="personas")
public class PersonaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String rut;
	
	@Column(name="primer_nombre")
	private String primerNombre;

	@Column(name="segundo_nombre")
	private String segundoNombre;
	
	@Column(name="apellido_paterno")
	private String apellidoPaterno;
	
	@Column(name="apellido_materno")
	private String apellidoMaterno;
	
	@Column(name="fecha_registro")
	private Date fechaRegistro;
	
	@Column(name="fecha_eliminado")
	private Date fechaEliminado;
	
	
}
