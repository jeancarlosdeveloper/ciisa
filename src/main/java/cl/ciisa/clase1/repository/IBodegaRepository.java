package cl.ciisa.clase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.ciisa.clase1.entitys.Bodega;

@Repository
public interface IBodegaRepository extends JpaRepository<Bodega, Long>  {
	
}
