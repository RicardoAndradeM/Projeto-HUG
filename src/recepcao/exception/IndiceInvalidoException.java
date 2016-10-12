package recepcao.exception;

/** Representa Exception caso o numero do quarto seja invalido
 * @since 1/10/2016
 */
public class IndiceInvalidoException extends RecepcaoException {

	private static final long serialVersionUID = -1879192774668500406L;

	public IndiceInvalidoException(String msg) {
		super(msg);
	}

}
