package cl.ciisa.clase1.DTO;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
	
	Date fechaPedido;
	Integer idCamarero;
	Integer idCocina;
	List<PedidoIngredienteDTO>listaIngredientes;
	
}
