package cl.ciisa.clase1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ciisa.clase1.DTO.ReservaDTO;
import cl.ciisa.clase1.mappers.IReservaMapper;
import cl.ciisa.clase1.repository.IReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private IReservaRepository reservaRepository;
	
	public List<ReservaDTO> findAll() {
		List<ReservaDTO>reservasDTO= IReservaMapper.INSTANCE.listReservaToListReservaDTO(reservaRepository.findAll());
		return reservasDTO;
	}
	
}
