package cadastro.exception;

/** Exeception lancao quando uma quarto ja esta sendo ocupado
 * @author Ricardo Andrade
 * @since 30/09/2016
 */
public class QuartoOcupadoException extends CadastroException {

	private static final long serialVersionUID = -8540800894345129333L;

	public QuartoOcupadoException(String msg) {
		super(msg);
	}
}
