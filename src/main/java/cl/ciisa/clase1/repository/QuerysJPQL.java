package cl.ciisa.clase1.repository;

public class QuerysJPQL {

	public static final String BUSCAR_CLIENTE = "SELECT p "
			+ "FROM Persona AS p " 
			+ "INNER JOIN Usuario AS u ON u.persona.id = p.id "
			+ "WHERE (:consultaPorRut = false OR p.rut = :rut) "
			+ "AND (:consultaPorPrimerNombre = false OR p.primerNombre LIKE %:primerNombre%) "
			+ "AND (:consultaPorSegundoNombre = false OR p.segundoNombre LIKE %:segundoNombre%) "
			+ "AND (:consultaPorTipoUsuario = false OR u.tipoUsuario.tipoUsuario LIKE %:tipoUsuario%)";
	
	public static final String BUSCAR_RESERVA = "SELECT rc "
			+ "FROM ReservaCliente AS rc " 
			+ "INNER JOIN Persona AS p ON p.id = rc.persona.id "
			+ "INNER JOIN Mesa AS m ON m.id = rc.mesa.id "
			+ "WHERE (:consultaPorRut = false OR p.rut = :rut) "
			+ "AND (:consultaPorFechaHoraReserva = false OR rc.fechaReserva = :fechaHoraReserva) "
			+ "AND (:consultaPorIdMesa = false OR m.id = :idMesa) ";
}
