package exceptions.valordeatributoinvalido;

/**
 * Representa Exception caso nome do atributo seja invalido
 * @since 13/09/16
 */
public class NomeDeAtributoInvalidoException extends ValorDeAtributoInvalidoException  {

	private static final long serialVersionUID = -152280583230952592L;
	
	public NomeDeAtributoInvalidoException(String msg) {
		super(msg);
	}
	
	public NomeDeAtributoInvalidoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
