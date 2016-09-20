package exceptions.valordeatributoinvalido;

public class NomeInvalidoException extends ValorDeAtributoInvalidoException  {
	
	private static final long serialVersionUID = -5347433941573592344L;

	public NomeInvalidoException(String msg) {
		super(msg);
	}
	
	public NomeInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
