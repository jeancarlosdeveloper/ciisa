package cl.ciisa.clase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.ciisa.clase1.entitys.ReservaCliente;

@Repository
public interface IReservaClienteRepository extends JpaRepository<ReservaCliente, Long> {

	@Query(QuerysJPQL.BUSCAR_RESERVA)
	ReservaCliente buscarReserva(
			@Param("consultaPorRut") Boolean consultaPorRut,
			@Param("consultaPorFechaHoraReserva") Boolean consultaPorFechaHoraReserva, 
			@Param("consultaPorIdMesa") Boolean consultaPorIdMesa,
			@Param("rut") String rut,
			@Param("fechaHoraReserva") String fechaHoraReserva, 
			@Param("idMesa") String idMesa);
}
