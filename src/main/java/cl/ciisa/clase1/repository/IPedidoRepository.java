package cl.ciisa.clase1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.ciisa.clase1.entitys.Pedido;

@Repository
public interface IPedidoRepository extends JpaRepository<Pedido, Long>{

}	
