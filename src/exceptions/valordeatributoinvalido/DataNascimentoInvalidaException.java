package exceptions.valordeatributoinvalido;

/**
 * Representa Exception caso data de nascimento seja invalido
 * @since 13/09/16
 */
public class DataNascimentoInvalidaException extends ValorDeAtributoInvalidoException {

	private static final long serialVersionUID = 5806738116400459074L;

	public DataNascimentoInvalidaException(String msg) {
		super(msg);
	}
	
	public DataNascimentoInvalidaException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
