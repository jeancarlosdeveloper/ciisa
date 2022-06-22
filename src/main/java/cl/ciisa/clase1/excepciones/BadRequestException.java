package cl.ciisa.clase1.excepciones;


public class BadRequestException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3178175058352364784L;
	
	private static final String DESCRIPTION = "Bad Request Exception (400)";
	
	public BadRequestException(String detail) {
		super(DESCRIPTION +". " +detail);
	}
	
}
