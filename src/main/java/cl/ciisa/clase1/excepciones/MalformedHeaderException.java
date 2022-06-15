package cl.ciisa.clase1.excepciones;

public class MalformedHeaderException extends BadRequestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Token with wrong format";
	
	public MalformedHeaderException(String detail) {
		super(DESCRIPTION +". " +detail);
	}

}
