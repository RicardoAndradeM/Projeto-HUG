package exceptions.naocadastrado;

public class HospedeNaoEncontradoException extends NaoCadastradoException {

	private static final long serialVersionUID = -673709273230389808L;
	
	public HospedeNaoEncontradoException(String msg) {
		super(msg);
	}
	
	public HospedeNaoEncontradoException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
