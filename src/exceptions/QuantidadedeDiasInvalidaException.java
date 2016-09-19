package exceptions;

public class QuantidadedeDiasInvalidaException extends Exception{

	private static final long serialVersionUID = -2533662229217053808L;

	public QuantidadedeDiasInvalidaException(String msg) {
		super(msg);
	}
	
	public QuantidadedeDiasInvalidaException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
