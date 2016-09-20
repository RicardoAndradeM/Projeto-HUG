package exceptions.valordeatributoinvalido;

public class EmailInvalidoException extends ValorDeAtributoInvalidoException  {

	private static final long serialVersionUID = -1000246698803637998L;

	public EmailInvalidoException(String msg) {
		super(msg);
	}
	
	public EmailInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
