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
public class CajaRegistroPagoDTO {

	Date fechaCompra;
	Integer monto;
	Integer idTipoPago;
	Integer idCajera;
	Integer idReservaCliente;

}
