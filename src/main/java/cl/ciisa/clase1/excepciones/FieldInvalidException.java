package cl.ciisa.clase1.excepciones;

public class FieldInvalidException extends BadRequestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "FieldInvalidException";
	
	public FieldInvalidException(String detail) {
		super(DESCRIPTION+" "+detail);
	}

}
