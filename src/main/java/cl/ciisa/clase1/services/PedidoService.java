package cl.ciisa.clase1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.DTO.PedidoDTO;
import cl.ciisa.clase1.DTO.PedidoGuardarDTO;
import cl.ciisa.clase1.DTO.ResponsePedidoDTO;
import cl.ciisa.clase1.entitys.Pedido;
import cl.ciisa.clase1.mappers.IPedidoMapper;
import cl.ciisa.clase1.repository.IPedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	IPedidoRepository pedidoRepository;
	
	public List<ResponsePedidoDTO> registrarPedidos(List<PedidoGuardarDTO>guardarPedidos) {
	   List<Pedido>rsp=	this.pedidoRepository.saveAll(IPedidoMapper.INSTANCE.pedidoGuardarDTOListToPedidoList(guardarPedidos));
	   return IPedidoMapper.INSTANCE.listPedidoToResponsePedidoDTO(rsp);
	}

}
