package execeptions;

public class dataNascimentoInvalidaException extends Exception {

	private static final long serialVersionUID = 5806738116400459074L;

	public dataNascimentoInvalidaException(String msg) {
		super(msg);
	}
	
	public dataNascimentoInvalidaException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
