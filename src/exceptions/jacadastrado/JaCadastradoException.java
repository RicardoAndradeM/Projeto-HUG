package exceptions.jacadastrado;

/**
 * Representa exception no caso de cliente ja cadastrado
 * @since 20/09/16
 */
public class JaCadastradoException extends Exception{
	
	private static final long serialVersionUID = -941220727755347328L;

	public JaCadastradoException(String msg) {
		super(msg);
	}
	
	public JaCadastradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
