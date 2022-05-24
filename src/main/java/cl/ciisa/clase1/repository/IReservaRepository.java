package cl.ciisa.clase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ciisa.clase1.entitys.Reserva;

public interface IReservaRepository extends JpaRepository<Reserva, Integer> {
	
}
