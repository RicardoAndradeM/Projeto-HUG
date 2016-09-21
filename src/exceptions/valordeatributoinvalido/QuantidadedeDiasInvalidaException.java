package exceptions.valordeatributoinvalido;

/**
 * Representa Exception caso quantidade de dias seja invalido
 * @since 13/09/16
 */
public class QuantidadedeDiasInvalidaException extends Exception {

	private static final long serialVersionUID = -2533662229217053808L;

	public QuantidadedeDiasInvalidaException(String msg) {
		super(msg);
	}
	
	public QuantidadedeDiasInvalidaException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
