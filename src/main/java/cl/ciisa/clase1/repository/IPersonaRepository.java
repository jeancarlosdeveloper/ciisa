package cl.ciisa.clase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cl.ciisa.clase1.entitys.Persona;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long>{
	
	@Query(QuerysJPQL.BUSCAR_CLIENTE)
	public Persona buscarPersona(
			@Param("consultaPorRut") Boolean consultaPorRut,
			@Param("consultaPorPrimerNombre") Boolean consultaPorPrimerNombre,
			@Param("consultaPorSegundoNombre") Boolean consultaPorSegundoNombre,
			@Param("consultaPorTipoUsuario") Boolean consultaPorTipoUsuario,
			@Param("rut") String rut,
			@Param("primerNombre") String primerNombre, 
			@Param("segundoNombre") String segundoNombre,
			@Param("tipoUsuario") String tipoUsuario); 

}
