package execeptions;

public class NomeDeAtributoInvalidoException extends Exception {

	private static final long serialVersionUID = -152280583230952592L;
	
	public NomeDeAtributoInvalidoException(String msg) {
		super(msg);
	}
	
	public NomeDeAtributoInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
