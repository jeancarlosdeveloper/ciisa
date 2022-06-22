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
public class ResponseCajaRegistroDTO {
	
	Long id;
	Date fechaCompra;
	Integer monto;
	Integer idTipoPago;
	Integer idCajera;
	Integer idReservaCliente;
	List<PedidoDTO>listaPedidos;
}
