package recepcao.exception;

/** Representa Exception caso o quarto jah esteja ocupado
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class QuartoOcupadoException extends RecepcaoException {

	private static final long serialVersionUID = 836213655797429860L;

	public QuartoOcupadoException(String msg) {
		super(msg);
	}
}
