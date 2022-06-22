package cl.ciisa.clase1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import cl.ciisa.clase1.DTO.ClienteDTO;
import cl.ciisa.clase1.entitys.Persona;
import cl.ciisa.clase1.entitys.Usuario;

@Mapper
public interface ISolicitudClienteMapper {

	ISolicitudClienteMapper INSTANCE = Mappers.getMapper(ISolicitudClienteMapper.class);

	@Mapping(target = "fechaRegistro", dateFormat = "dd-MM-yyyy hh:mm:ss")
	Persona registroClienteToPersona(ClienteDTO registroCliente);
	
	@Mappings({
		@Mapping(source= "idTipoUsuario", target="tipoUsuario.id"),
		@Mapping(source= "estado", target="activo"),
		@Mapping(source= "id", target="persona.id")
	})
	Usuario registroClienteToUsuario(ClienteDTO registroCliente);
	
	
}
