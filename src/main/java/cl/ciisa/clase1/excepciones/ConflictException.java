package cl.ciisa.clase1.excepciones;

public class ConflictException  extends RuntimeException{
	
private static final long serialVersionUID = 1L;
	
	private static final String DESCRIPTION = "Conflict Exception (409)";
	
	public ConflictException(String detail) {
		super(DESCRIPTION +". " +detail);
	}
}
