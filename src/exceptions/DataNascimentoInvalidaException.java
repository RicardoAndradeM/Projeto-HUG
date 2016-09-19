package exceptions;

public class DataNascimentoInvalidaException extends Exception {

	private static final long serialVersionUID = 5806738116400459074L;

	public DataNascimentoInvalidaException(String msg) {
		super(msg);
	}
	
	public DataNascimentoInvalidaException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
