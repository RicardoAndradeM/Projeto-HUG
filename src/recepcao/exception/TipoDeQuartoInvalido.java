package recepcao.exception;

/** Representa Exception caso tipo de quarto seja invalido
 * @author Ricardo Andrade
 * @since 09/10/2016
 */
public class TipoDeQuartoInvalido extends RecepcaoException {

	private static final long serialVersionUID = -7246208793729479693L;

	public TipoDeQuartoInvalido(String msg) {
		super(msg);
	}

}
