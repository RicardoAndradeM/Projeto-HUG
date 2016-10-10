package recepcao.exception;

/** Representa Exception caso o quarto nao esta ocupado
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class QuartoDesocupadoException extends RecepcaoException {
	
	private static final long serialVersionUID = 1998062087309637298L;

	public QuartoDesocupadoException(String msg) {
		super(msg);
	}

}
