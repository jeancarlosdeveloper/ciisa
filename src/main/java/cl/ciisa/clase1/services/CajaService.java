package cl.ciisa.clase1.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.DTO.FrontCajaRegistroPagoDTO;
import cl.ciisa.clase1.DTO.PedidoGuardarDTO;
import cl.ciisa.clase1.DTO.ResponseCajaRegistroDTO;
import cl.ciisa.clase1.DTO.ResponsePedidoDTO;
import cl.ciisa.clase1.entitys.Caja;
import cl.ciisa.clase1.mappers.ICajaMapper;
import cl.ciisa.clase1.mappers.IPedidoMapper;
import cl.ciisa.clase1.repository.ICajaRepository;

@Service
public class CajaService {

	@Autowired
	ICajaRepository cajaRepository;
	
	@Autowired
	PedidoService pedidoService;
	
	public FrontCajaRegistroPagoDTO registrarPago(FrontCajaRegistroPagoDTO solicitudRegistro) {

		//1) Registrar en caja
		ResponseCajaRegistroDTO cajaRegistrada=this.registrarCaja(solicitudRegistro);
		
		//2) Registrar pedido asociados a la caja
		List<PedidoGuardarDTO>solicitudPedidos= IPedidoMapper.INSTANCE.pedidoDTOToPedidoGuardarDTO(solicitudRegistro.getListaPedidos());
		List<PedidoGuardarDTO>pedidosARegistrar = solicitudPedidos.stream().map(p-> { p.setIdCaja(cajaRegistrada.getId());return p;}).collect(Collectors.toList());
	
		List<ResponsePedidoDTO>pedidosGuardados= this.pedidoService.registrarPedidos(pedidosARegistrar);
		
		System.out.println("Realizado satisfactoriamente");
		
		
		

		
		
		return null;
	}

	
	

	private ResponseCajaRegistroDTO registrarCaja(FrontCajaRegistroPagoDTO solicitudRegistro) {
		Caja converirAEntidad = ICajaMapper.INSTANCE.cajaRegistroPagoDTOToCaja(solicitudRegistro);
		ResponseCajaRegistroDTO convertirADTO = ICajaMapper.INSTANCE.cajaToCajaRegistroPagoDTO(cajaRepository.save(converirAEntidad));
		return convertirADTO;
	}
	
	
	
	public void obtenerConsumosMesa() {
		
	}

}
