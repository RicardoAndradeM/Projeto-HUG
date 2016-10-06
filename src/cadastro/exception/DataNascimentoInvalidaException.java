package cadastro.exception;

/**Representa Exception caso data de nascimento seja invalido
 * @author Ricardo Andrade
 * @since 13/09/2016
 */
public class DataNascimentoInvalidaException extends CadastroException {

	private static final long serialVersionUID = 5806738116400459074L;

	public DataNascimentoInvalidaException(String msg) {
		super(msg);
	}
}
