package cl.ciisa.clase1.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@Entity
@Table(name="personas")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Length(min=10, max=10)
	@Column(unique = true)
	String rut;
	
	@Column(name="primer_nombre", nullable=false)
	String primerNombre;

	@Column(name="segundo_nombre")
	String segundoNombre;
	
	@Column(name="apellido_paterno", nullable=false)
	String apellidoPaterno;
	
	@Column(name="apellido_materno")
	String apellidoMaterno;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_registro")
	Date fechaRegistro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_eliminado")
	Date fechaEliminado;
	
}
