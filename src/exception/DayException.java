package exception;

public class DayException extends Exception {

	private static final long serialVersionUID = 1L;

	public DayException() {
		super("No puedes ingresar al minimercado, el dia actual no concuerda con el dia de salida del penultimo digito de tu documento de identidad");
	}

}
