package cl.ciisa.clase1.DTO;

import cl.ciisa.clase1.entitys.Persona;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservacionDTO {
	
	Long id;
	String fechaReserva;
	Persona persona;
	Long idTipoUsuario;
	Long idMesa;
}
