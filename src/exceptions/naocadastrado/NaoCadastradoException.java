package exceptions.naocadastrado;

public class NaoCadastradoException extends Exception {
	
	private static final long serialVersionUID = 1276256438398021120L;

	public NaoCadastradoException(String msg) {
		super(msg);
	}
	
	public NaoCadastradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
