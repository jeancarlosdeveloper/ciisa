package cl.ciisa.clase1.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePedidoDTO {
	
	Integer id;
	Date fechaPedido;
	Integer idCaja;
	Integer idCamarero;
	Integer idCocina;
	
}
