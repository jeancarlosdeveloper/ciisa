package cl.ciisa.clase1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import cl.ciisa.clase1.DTO.ClienteDTO;
import cl.ciisa.clase1.entitys.Persona;

@Mapper
public interface IPersonaMapper {
	
	IPersonaMapper INSTANCE = Mappers.getMapper(IPersonaMapper.class);
	

	
}
