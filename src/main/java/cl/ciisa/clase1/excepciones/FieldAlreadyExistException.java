package cl.ciisa.clase1.excepciones;

import org.springframework.core.annotation.Order;

@Order(1)
public class FieldAlreadyExistException extends ConflictException {

	private static final String DESCRIPTION = "El campo esta duplicado en base de datos.";
	
	private static final long serialVersionUID = 1L;

	public FieldAlreadyExistException(String detail) {
		super(DESCRIPTION+ detail);
	}

}
