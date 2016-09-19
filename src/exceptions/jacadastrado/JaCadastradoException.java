package exceptions.jacadastrado;

public class JaCadastradoException extends Exception{
	
	private static final long serialVersionUID = -941220727755347328L;

	public JaCadastradoException(String msg) {
		super(msg);
	}
	
	public JaCadastradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
