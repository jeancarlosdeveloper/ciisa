package cl.ciisa.clase1.entitys;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="caja")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Caja {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	Date fechaCompra;
	
	Integer monto;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_pago")
	TipoPago tipoPago;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_cajera")
	Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_reserva_cliente")
	ReservaCliente reservaCliente;

}
