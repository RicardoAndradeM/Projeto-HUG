package cadastro.exception;

/** Representa Exception caso se tente manipular algum atributo do hospede que nao exista
 * @author Ricardo Andrade
 * @since 06/10/2016
 */
public class AtributoInvalidoException extends CadastroException {

	private static final long serialVersionUID = 3316376287787743279L;

	public AtributoInvalidoException(String msg) {
		super(msg);
	}

}
