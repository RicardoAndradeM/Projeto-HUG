package cadastro.exception;

/** Representa Exception caso nome seja invalido
 * @author Ricardo Andrade
 * @since 20/09/2016
 */
public class NomeInvalidoException extends CadastroException  {
	
	private static final long serialVersionUID = -5347433941573592344L;

	public NomeInvalidoException(String msg) {
		super(msg);
	}
}
