package cadastro.exception;

/** Exeception lancado quando o quarto nao é encontrado
 * @author Ricardo Andrade
 * @since 30/09/2016
 */
public class QuartoNaoEncontradoException extends CadastroException {
	
	private static final long serialVersionUID = 8117570053552244888L;

	public QuartoNaoEncontradoException(String msg) {
		super(msg);
	}

}
