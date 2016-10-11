package recepcao.exception;

/** Representa Exception caso dias das estadia sejam invalido
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class DiasInvalidoException extends RecepcaoException {

	private static final long serialVersionUID = -941402966094720555L;

	public DiasInvalidoException(String msg) {
		super(msg);
	}

}
