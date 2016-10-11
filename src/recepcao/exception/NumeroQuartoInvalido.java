package recepcao.exception;

/** Representa Exception caso o numero do quarto seja invalido
 * @since 09/10/2016
 */
public class NumeroQuartoInvalido extends RecepcaoException {

	private static final long serialVersionUID = 3953005274510873947L;

	public NumeroQuartoInvalido(String msg) {
		super(msg);
	}

}
