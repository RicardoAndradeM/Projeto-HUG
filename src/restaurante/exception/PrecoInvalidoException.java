package restaurante.exception;

/** Lanca exception caso
 * @author ricardo
 * @since 12/10/2016
 */
public class PrecoInvalidoException extends RestauranteException {

	private static final long serialVersionUID = -3555910606155165280L;

	public PrecoInvalidoException(String msg) {
		super(msg);
	}

}
