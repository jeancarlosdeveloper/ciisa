package cl.ciisa.clase1.DTO;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CajaRegistroPagoDTO {
	
	private Date fechaCompra;
	private Integer monto;
	private Integer idTipoPago;
	private Integer idCajera;
	private Integer idReservaCliente;
	
}
