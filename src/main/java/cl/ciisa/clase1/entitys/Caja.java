package cl.ciisa.clase1.entitys;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="caja")
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

}
