package exceptions.valordeatributoinvalido;

public class ValorDeAtributoInvalidoException extends Exception {
	
	private static final long serialVersionUID = -1337072828573120916L;

	public ValorDeAtributoInvalidoException(String msg) {
		super(msg);
	}
	
	public ValorDeAtributoInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
