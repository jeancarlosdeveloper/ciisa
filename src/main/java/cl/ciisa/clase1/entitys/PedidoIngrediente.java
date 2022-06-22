package cl.ciisa.clase1.entitys;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="pedidos_ingredientes")
public class PedidoIngrediente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	@ManyToOne
	@JoinColumn(name="id_pedido")
	Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name="id_ingrediente")
	Ingrediente ingrediente;
	
	Integer cantidad;
	
}
