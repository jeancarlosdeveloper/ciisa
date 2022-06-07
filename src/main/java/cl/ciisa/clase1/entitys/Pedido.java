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
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@Column(name="fecha_pedido")
	Date fechaPedido;
	
	@ManyToOne
	@JoinColumn(name="id_caja")
	Caja caja;
	
	@ManyToOne
	@JoinColumn(name="id_usuario_camarero")
	Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_cocina")
	Cocina cocina;
	
}
