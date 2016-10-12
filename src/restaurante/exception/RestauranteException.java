package restaurante.exception;

/** Classe que representa exception mae de Restaurante
 * @author Ricardo Andrade
 * @since 12/10/2016
 */
public class RestauranteException extends Exception {

	private static final long serialVersionUID = 1860306784045356590L;
	
	public RestauranteException(String msg) {
		super(msg);
	}
}
