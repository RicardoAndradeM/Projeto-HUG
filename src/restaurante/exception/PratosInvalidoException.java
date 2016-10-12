package restaurante.exception;

/** Lanca exception caso pratos sejam invalidos
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class PratosInvalidoException extends RestauranteException {

	private static final long serialVersionUID = -7998679480489744884L;

	public PratosInvalidoException(String msg) {
		super(msg);
	}

}
