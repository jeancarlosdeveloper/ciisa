package cl.ciisa.clase1.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import cl.ciisa.clase1.DTO.PedidoDTO;
import cl.ciisa.clase1.DTO.PedidoGuardarDTO;
import cl.ciisa.clase1.DTO.ResponsePedidoDTO;
import cl.ciisa.clase1.entitys.Pedido;

@Mapper
public interface IPedidoMapper {

	IPedidoMapper INSTANCE = Mappers.getMapper(IPedidoMapper.class);

	List<PedidoGuardarDTO> pedidoDTOToPedidoGuardarDTO(List<PedidoDTO> pedidoDTO);

	List<PedidoDTO> listPedidoToPedidoDTO(List<Pedido> listPedido);

	@Mapping(source = "listPedidoGuardarDTO.idCaja", target = "caja.id")
	@Mapping(source = "listPedidoGuardarDTO.idCamarero", target = "usuario.id")
	@Mapping(source = "listPedidoGuardarDTO.idCocina", target = "cocina.id")
	List<Pedido> pedidoGuardarDTOListToPedidoList(List<PedidoGuardarDTO> listPedidoGuardarDTO);

	List<ResponsePedidoDTO> listPedidoToResponsePedidoDTO(List<Pedido> listPedidosDTO);

}
