package cadastro.exception;

/** Representa Exception caso alguma solicitacao de um hospede nao cadastrado seja feita
 * @author Ricardo Andrade
 * @since 06/10/2016
 */
public class HospedeNaoCadastradoException extends CadastroException {
	private static final long serialVersionUID = 9100556575942487932L;

	public HospedeNaoCadastradoException(String msg) {
		super(msg);
	}

}
