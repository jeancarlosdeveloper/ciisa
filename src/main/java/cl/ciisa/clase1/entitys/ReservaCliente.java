package cl.ciisa.clase1.entitys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas_clientes")
public class ReservaCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="fecha_reserva")
	Date fechaReserva;
	
	@ManyToOne
	@JoinColumn(name="id_persona")
	Persona persona;

	@ManyToOne
	@JoinColumn(name="id_mesa")
	Mesa mesa;
	
}
