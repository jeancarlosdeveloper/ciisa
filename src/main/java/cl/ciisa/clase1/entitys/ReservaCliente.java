package cl.ciisa.clase1.entitys;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="reservas_clientes")
public class ReservaCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="fecha_reserva", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date fechaReserva;
	
	
	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="id_persona", nullable = false)
	Persona persona;

	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.DETACH)
	@JoinColumn(name="id_mesa", nullable = false)
	Mesa mesa;
	
}
