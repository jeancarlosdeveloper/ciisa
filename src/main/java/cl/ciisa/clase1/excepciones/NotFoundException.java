package cl.ciisa.clase1.excepciones;

public class NotFoundException extends RuntimeException {
	
private static final long serialVersionUID = -3178175058352364784L;
	
	private static final String DESCRIPTION = "Not Found Exception (404)";
	
	public NotFoundException(String detail) {
		super(DESCRIPTION +". " +detail);
	}
}
