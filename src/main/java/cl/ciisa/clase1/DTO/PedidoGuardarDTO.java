package cl.ciisa.clase1.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoGuardarDTO {
	
	Date fechaPedido;
	Long idCaja;
	Long idCamarero;
	Long idCocina;
}
