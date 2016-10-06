package cadastro.exception;

/**Representa Exception caso email seja invalido
 * @author Ricardo Andrade
 * @since 13/09/2016
 */
public class EmailInvalidoException extends CadastroException  {

	private static final long serialVersionUID = -1000246698803637998L;

	public EmailInvalidoException(String msg) {
		super(msg);
	}
}
