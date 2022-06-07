package cl.ciisa.clase1.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Length(min=10, max=10)
	String rut;
	
	@NotNull
	@Column(name="primer_nombre")
	String primerNombre;

	@Column(name="segundo_nombre")
	String segundoNombre;
	
	@NotNull
	@Column(name="apellido_paterno")
	String apellidoPaterno;
	
	@Column(name="apellido_materno")
	String apellidoMaterno;
	
	@Column(name="fecha_registro")
	Date fechaRegistro;
	
	@Column(name="fecha_eliminado")
	Date fechaEliminado;
	
	
}
