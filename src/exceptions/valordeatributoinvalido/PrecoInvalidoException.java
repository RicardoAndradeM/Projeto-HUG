package exceptions.valordeatributoinvalido;

public class PrecoInvalidoException extends ValorDeAtributoInvalidoException {

	private static final long serialVersionUID = 6778763419318901999L;

	public PrecoInvalidoException(String msg) {
		super(msg);
	}
	
	public PrecoInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
