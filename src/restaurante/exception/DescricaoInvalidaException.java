package restaurante.exception;

/** Lanca exeception caso Descricao seja inalida
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class DescricaoInvalidaException extends RestauranteException {

	private static final long serialVersionUID = 4347664182447380193L;

	public DescricaoInvalidaException(String msg) {
		super(msg);
	}

}
