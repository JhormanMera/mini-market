package exception;

public class AgeException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public AgeException() {
		super("El ingreso a menores de edad no esta permitido actualmente en el minimercado");
	}

}
